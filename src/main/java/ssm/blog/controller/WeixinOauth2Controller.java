package ssm.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.entity.SexType;
import ssm.blog.entity.AccessToken;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.ExchangeService;
import ssm.blog.util.PageUtil;
import ssm.blog.util.StringUtil;
import ssm.blog.util.WeixinUtil;

/**
 * @Description Controller
 * @author songml
 *
 */
@Controller
@RequestMapping("/weixin_oauth2")
public class WeixinOauth2Controller {
	private static Logger logger = Logger.getLogger(WeixinOauth2Controller.class);
	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource(name="exchangeService")
	private ExchangeService exchangeService;
	
	@Value("#{setting[APPID]}")
	private String strAPPID; 
	
	@Value("#{setting[APPSECRET]}")
	private String strAPPSECRET; 
	/**
	 * @Description 
	 * @return
	 */
	@RequestMapping("/get_code")
	public ModelAndView get_code(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception {
		
		logger.info("["+this.getClass()+"][get_code][start]");
		
		
		String str_code = request.getParameter("code");//我们要的code
		logger.info("["+this.getClass()+"][get_code][CODE]"+str_code);
		WeixinUtil wu = new WeixinUtil();
		AccessToken accessToken = wu.get_oauth2_access_token_from_url(strAPPID, strAPPSECRET,str_code);
		logger.info("["+this.getClass()+"][get_code][openId]"+accessToken.getOpenid());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("strResult", str_code);
		


		modelAndView.setViewName("result");
		
		
		
		
		
		logger.info("["+this.getClass()+"][get_code][end]");
		return modelAndView;

	}

}
