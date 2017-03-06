package ssm.blog.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;
import ssm.blog.util.CryptographyUtil;

/**
 * @Description 博主Controller层，前台部分，不需要认证
 * @author Ni Shengwu
 *
 */
@Controller
@RequestMapping("/blogger")
public class BloggerController {
	private static Logger logger = Logger.getLogger(BloggerController.class);
	@Resource
	private BloggerService bloggerService;
	
	@RequestMapping("/login")
	public String login(Blogger blogger, HttpServletRequest request) {
		logger.info("["+this.getClass()+"][login][start]");
		Subject subject = SecurityUtils.getSubject(); //获取当前登陆的主体
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "javacoder");//将密码使用md5加密
		logger.info("["+this.getClass()+"][login][start]:"+newPassword);
		//将用户信息封装到token中
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		try {
			subject.login(token); //会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
			logger.info("["+this.getClass()+"][login][end]");
			return "redirect:/admin/main.jsp";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("bloger", blogger);
			request.setAttribute("errorInfo", "用户名或密码错误");
			logger.info("["+this.getClass()+"][login][end]error");
			return "login";
		} 

	}
	
	@RequestMapping("/aboutme")
	public ModelAndView abouotMe() {
		ModelAndView modelAndView = new ModelAndView();
		Blogger blogger = bloggerService.getBloggerData();
		modelAndView.addObject("blogger", blogger);
		modelAndView.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
		modelAndView.addObject("title", "关于");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping("/myalbum")
	public ModelAndView myAlbum() {
		ModelAndView modelAndView = new ModelAndView();
		//要写一个相册的service获取相册
		//要建一个相册表
		//....
		modelAndView.addObject("commonPage", "foreground/blogger/myAlbum.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping("/resource")
	public ModelAndView resource() {
		ModelAndView modelAndView = new ModelAndView();
		//
		//....
		modelAndView.addObject("commonPage", "foreground/blogger/resource.jsp");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
}
