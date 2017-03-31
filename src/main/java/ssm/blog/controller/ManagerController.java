package ssm.blog.controller;


import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import ssm.blog.entity.AccessToken;
import ssm.blog.service.AccessTokenService;
import ssm.blog.service.MenuService;
import ssm.blog.util.WeixinUtil;

@Controller
public class ManagerController {
	
	private static Logger logger = Logger.getLogger(MenuService.class);
	

	@Resource(name="accessTokenService")
	private AccessTokenService accessTokenService;
	
	
	@Value("#{setting[APPID]}")
	private String strAPPID; 
	
	@Value("#{setting[APPSECRET]}")
	private String strAPPSECRET; 
	
	@RequestMapping(value="/manager/get_access_token",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView get_access_token() throws FileNotFoundException, IOException{
		
		logger.info("["+this.getClass().getName()+"][get_access_token][start]"); 
		ModelAndView mv=new ModelAndView();
        // 调用接口获取access_token
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPID]"+strAPPID);
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPSECRET]"+strAPPSECRET);
		//String tmp = PropertiesUtil.getProperties();
        AccessToken at = accessTokenService.getAccessToken();
        logger.info("["+this.getClass().getName()+"][get_access_token][accessToken]"+at.getAccess_token());
        mv.addObject("sidebar","get_access_token");
        mv.setViewName("result");
        mv.addObject("strResult", at.getAccess_token());
		//mv.addObject("sidebar","classes");
		logger.info("["+this.getClass().getName()+"][get_access_token][end]"); 
		return mv;
	}

	@RequestMapping(value="/manager/get_union_id",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView get_union_id() throws FileNotFoundException, IOException{
		
		logger.info("["+this.getClass().getName()+"][get_union_id][start]"); 
		ModelAndView mv=new ModelAndView();
        // 调用接口获取access_token
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPID]"+strAPPID);
		//logger.info("["+this.getClass().getName()+"][get_access_token][strAPPSECRET]"+strAPPSECRET);
		//String tmp = PropertiesUtil.getProperties();
        AccessToken at = accessTokenService.getAccessToken();
        
        logger.info("["+this.getClass().getName()+"][get_union_id][accessToken]"+at.getAccess_token());
        
        String str_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        
        String requestUrl = str_url.replace("OPENID", "o08GJwa_rYPdbwV6jDi2ZTaXyJ6s").replace("ACCESS_TOKEN", at.getAccess_token());
        
        JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
        
		// 如果请求成功
		if (null != jsonObject) {
			try {
				mv.addObject("strResult", jsonObject.toString());
			} catch (JSONException e) {
				// 获取token失败
				logger.error("LINGZHU:获取token失败 errcode:{} errmsg:{}");
			}
		}
		mv.addObject("sidebar","get_union_id");
        mv.setViewName("result");
        
		//mv.addObject("sidebar","classes");
		logger.info("["+this.getClass().getName()+"][get_union_id][end]"); 
		return mv;
	}
	
	

	
}
