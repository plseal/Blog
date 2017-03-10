package ssm.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.entity.PageBean;
import ssm.blog.lucene.BlogIndex;
import ssm.blog.service.BlogService;
import ssm.blog.service.CommentService;
import ssm.blog.util.PageUtil;
import ssm.blog.util.StringUtil;

/**
 * @Description 
 * @author songml
 *
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
	private static Logger logger = Logger.getLogger(BlogController.class);
	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	public static final int pagesize = 8;
	
	@Value("#{setting[STR1]}")
	private String STR1; 

	@Value("#{setting[STR2]}")
	private String STR2; 
	
	@Value("#{setting[STR3]}")
	private String STR3; 
	
	@Value("#{setting[STR4]}")
	private String STR4;
	
	private BlogIndex blogIndex = new BlogIndex();

	
	@RequestMapping("/articles/{id}")
	public ModelAndView details(@PathVariable("id") Integer id,
			HttpServletRequest request) {
		logger.info("["+this.getClass()+"][articles][start]");
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findById(id); 

		String keyWords = blog.getKeyWord();
		if (StringUtil.isNotEmpty(keyWords)) {
			String[] strArray = keyWords.split(" ");
			List<String> keyWordsList = StringUtil.filterWhite(Arrays
					.asList(strArray));
			modelAndView.addObject("keyWords", keyWordsList);
		} else {
			modelAndView.addObject("keyWords", null);
		}

		modelAndView.addObject("blog", blog);
		blog.setClickHit(blog.getClickHit() + 1); 
		blogService.update(blog); 

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("blogId", blog.getId());
		map.put("state", 1);
		List<Comment> commentList = commentService.getCommentData(map);

		modelAndView.addObject("commentList", commentList);
		modelAndView.addObject("commonPage", "foreground/blog/blogDetail.jsp");
		modelAndView.addObject("title", blog.getTitle() + " ");

		modelAndView.addObject("pageCode", getPrevAndNextPageCode(
				blogService.getPrevBlog(id), blogService.getNextBlog(id),
				request.getServletContext().getContextPath()));

		modelAndView.setViewName("mainTemp");
		logger.info("["+this.getClass()+"][articles][end]");
		return modelAndView;
	}

	@RequestMapping("/search")
	public ModelAndView search(
			@RequestParam(value = "q", required = false) String q,
			@RequestParam(value = "page", required = false) String page,
			HttpServletRequest request) throws Exception {

		int pageSize = 10;
		ModelAndView modelAndView = new ModelAndView();
		List<Blog> blogIndexList = blogIndex.searchBlog(q);
		if(page == null) { 
			page = "1";
		}
		int fromIndex = (Integer.parseInt(page) - 1) * pageSize; 
		int toIndex = blogIndexList.size() >= Integer.parseInt(page) * pageSize ? Integer
				.parseInt(page) * pageSize
				: blogIndexList.size();
		modelAndView.addObject("blogIndexList", blogIndexList.subList(fromIndex, toIndex));
		modelAndView.addObject("pageCode", PageUtil.getUpAndDownPageCode(
				Integer.parseInt(page), blogIndexList.size(), q, pageSize,
				request.getServletContext().getContextPath()));
		modelAndView.addObject("q", q); 
		modelAndView.addObject("resultTotal", blogIndexList.size()); 
		modelAndView.addObject("commonPage", "foreground/blog/searchResult.jsp");
		modelAndView.addObject("title", "search'" + q + "'result");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping(value="/to_writeBlog",method=RequestMethod.GET)
	public ModelAndView writeBlog(){
		logger.info("["+this.getClass()+"][writeBlog][start]");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("writeBlog");
		
		mv.addObject("sidebar","writeBlog");
		logger.info("["+this.getClass()+"][writeBlog][end]");
		return mv;
	}
	
	@RequestMapping(value="/to_blogManage")
	public ModelAndView blogManage(
			HttpServletRequest request
			){
		logger.info("["+this.getClass()+"][blogManage][start]");
		String pagenum =request.getParameter("pagenum");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("blogManage");
		
		mv.addObject("sidebar","blogManage");
		logger.info("["+this.getClass()+"][blogManage][pagenum11]"+pagenum);
		if (pagenum ==null){
			pagenum ="1";
		}
		logger.info("["+this.getClass()+"][blogManage][pagenum]"+pagenum);
		PageBean pageBean = new PageBean(Integer.parseInt(pagenum), pagesize);
		Map<String, Object> map = new HashMap<String, Object>();
		 
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogList = blogService.listBlog(map);
		List<Blog> blogListOut = null;
		for (int i=0 ; i< blogList.size();i++) {
			  SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  blogList.get(i).setReleaseDateStr(dateformat1.format(blogList.get(i).getReleaseDate()));
			
		}
		//logger.info("["+this.getClass()+"][blogManage][blog]"+blogList.get(0).getReleaseDateStr());

		logger.info("["+this.getClass()+"][blogManage][blogList]"+blogList.size());
		Long total = blogService.getTotal(map);
		
		mv.addObject("blogList", blogList);
		//result.put("rows", jsonArray);
		//result.put("total", total);
		//ResponseUtil.write(response, result);
		mv.addObject("length", blogList.size());

		mv.addObject("pagenum", pagenum);
		
		logger.info("["+this.getClass()+"][blogManage][end]");
		return mv;
	}
	public String getPrevAndNextPageCode(Blog prev, Blog next, String projectContent) {
		logger.info("[PageUtil][getPrevAndNextPageCode][start]");
		StringBuffer pageCode = new StringBuffer();
		if(prev == null || prev.getId() == null) {
			pageCode.append("<p>" + STR1 + "</P>");
		} else {
			pageCode.append("<p>" + STR2 +"<a href='" + projectContent + "/blog/articles/" + prev.getId() + ".html'>" + prev.getTitle() + "</a></p>");
		}
		
		if(next == null || next.getId() == null) {
			pageCode.append("<p>" + STR3 + "</P>");
		} else {
			pageCode.append("<p>" + STR4 + "<a href='" + projectContent + "/blog/articles/" + next.getId() + ".html'>" + next.getTitle() + "</a></p>");
		}
		logger.info("[PageUtil][getPrevAndNextPageCode][pageCode.toString()]"+pageCode.toString());
		logger.info("[PageUtil][getPrevAndNextPageCode][end]");
		return pageCode.toString();
	}

	
}
