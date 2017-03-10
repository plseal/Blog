package ssm.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.controller.IndexController;
import ssm.blog.entity.Blog;
import ssm.blog.entity.PageBean;
import ssm.blog.lucene.BlogIndex;
import ssm.blog.service.BlogService;
import ssm.blog.service.CommentService;
import ssm.blog.util.DateJsonValueProcessor;
import ssm.blog.util.ResponseUtil;
import ssm.blog.util.StringUtil;

/**
 * @Description 
 * @author songml
 *
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {
	private static Logger logger = Logger.getLogger(BlogAdminController.class);
	@Resource
	private BlogService blogService;
	@Resource
	private CommentService commentService;
	
	private BlogIndex blogIndex = new BlogIndex();


	
	
	
	@RequestMapping("/save")
	public String save(Blog blog, HttpServletResponse response) throws Exception {
		logger.info("["+this.getClass()+"][save][start]");
		logger.info("["+this.getClass()+"][save][blogTitle]"+blog.getTitle());
		logger.info("["+this.getClass()+"][save][blogTypeId]"+blog.getBlogTypeId());
		logger.info("["+this.getClass()+"][save][getContentNoTag]"+blog.getContentNoTag());
		
		
		int resultTotal = 0; 
		if(blog.getId() == null) { 
			resultTotal = blogService.addBlog(blog);
			blogIndex.addIndex(blog); 
		} else { 
			resultTotal = blogService.update(blog);
			blogIndex.updateIndex(blog);
		}
		
		JSONObject result = new JSONObject();
		if(resultTotal > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][save][end]");
		return null;
	}
	
	@RequestMapping("/listBlog")
	public String listBlog(
			@RequestParam(value="page", required=false)String page,
			@RequestParam(value="rows", required=false)String rows,
			Blog s_blog,
			HttpServletResponse response) throws Exception {
		
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", StringUtil.formatLike(s_blog.getTitle())); 
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		List<Blog> blogList = blogService.listBlog(map);
		Long total = blogService.getTotal(map);
		
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(blogList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	

	@RequestMapping("/delete")
	public String deleteBlog(
			@RequestParam(value="ids", required=false)String ids,
			HttpServletResponse response) throws Exception {
		
		String[] idsStr = ids.split(",");
		for(int i = 0; i < idsStr.length; i++) {
			int id = Integer.parseInt(idsStr[i]);
			commentService.deleteCommentByBlogId(id);
			blogService.deleteBlog(id);
			blogIndex.deleteIndex(idsStr[i]);
		}
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	@RequestMapping("/findById")
	public String findById(
			@RequestParam(value="id", required=false)String id,
			HttpServletResponse response) throws Exception {
		
		Blog blog = blogService.findById(Integer.parseInt(id));
		JSONObject result = JSONObject.fromObject(blog);
		ResponseUtil.write(response, result);
		return null;
	}
}