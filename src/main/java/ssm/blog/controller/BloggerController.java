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
 * @Description ����Controller�㣬ǰ̨���֣�����Ҫ��֤
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
		//Subject subject = SecurityUtils.getSubject(); //��ȡ��ǰ��½������
		String newPassword = CryptographyUtil.md5(blogger.getPassword(), "javacoder");//������ʹ��md5����
		//���û���Ϣ��װ��token��
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), newPassword);
		try {
			//subject.login(token); //�����MyRealm�е�doGetAuthenticationInfo�������������֤
			if ("lingzhu".equals(blogger.getUsername())) {
				logger.info("["+this.getClass()+"][login][end] goto main.jsp");
				return "/admin/main";
			} else {
				request.setAttribute("bloger", blogger);
				request.setAttribute("errorInfo", "�û������������");
				logger.info("["+this.getClass()+"][login][end]");
				return "login";
			}
				
			
		} catch (AuthenticationException e) {
			e.printStackTrace();
			request.setAttribute("bloger", blogger);
			request.setAttribute("errorInfo", "�û������������");
			logger.info("["+this.getClass()+"][login][end]");
			return "login";
		} 

	}
	
	@RequestMapping("/aboutme")
	public ModelAndView abouotMe() {
		ModelAndView modelAndView = new ModelAndView();
		Blogger blogger = bloggerService.getBloggerData();
		modelAndView.addObject("blogger", blogger);
		modelAndView.addObject("commonPage", "foreground/blogger/bloggerInfo.jsp");
		modelAndView.addObject("title", "���ڱ�ϵͳ - ���������¹���");
		modelAndView.setViewName("mainTemp");
		return modelAndView;
	}
	
	@RequestMapping("/myalbum")
	public ModelAndView myAlbum() {
		ModelAndView modelAndView = new ModelAndView();
		//Ҫдһ������service��ȡ���
		//Ҫ��һ������
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
