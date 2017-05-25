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


import ssm.blog.entity.Blog;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.PageBean;
import ssm.blog.entity.SexType;
import ssm.blog.entity.AccessToken;
import ssm.blog.entity.ChildHealthRecord;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.ExchangeService;
import ssm.blog.service.ChildHealthRecordService;
import ssm.blog.util.PageUtil;
import ssm.blog.util.StringUtil;
import ssm.blog.util.WeixinUtil;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
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
	
	@Resource
	private ChildHealthRecordService childHealthRecordService;
	
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
		
		AccessToken accessToken = get_oauth2_access_token_from_url(str_code);
		logger.info("["+this.getClass()+"][get_code][openId]"+accessToken.getOpenid());
		ModelAndView mv = new ModelAndView();
		mv.addObject("openid", accessToken.getOpenid());
		//初期画面
		mv.addObject("hid_flg", "init");
		mv.setViewName("forward:../child_health_record/to_child_health_record_manage.do");
		
		logger.info("["+this.getClass()+"][get_code][end]");
		return mv;

	}
	
/**
	 * 获取oauth2_access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @param CODE
	 * @return
	 */
	private AccessToken get_oauth2_access_token_from_url( String code) {
		
		
		logger.info("[WeixinUtil][get_oauth2_access_token_from_url][start]");
		
	// 获取oauth2_access_token的接口地址（GET） 限200（次/天）
	    String oauth2_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

		AccessToken accessToken = null;

		String requestUrl = oauth2_access_token_url.replace("APPID", strAPPID).replace("SECRET", strAPPSECRET).replace("CODE", code);
		logger.info("[WeixinUtil][get_oauth2_access_token_from_url][requestUrl]"+requestUrl);
		JSONObject jsonObject = WeixinUtil.httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setAccess_token(jsonObject.getString("access_token"));
				accessToken.setOpenid(jsonObject.getString("openid"));
				accessToken.setExpires_in(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				logger.info("LINGZHU:获取token失败 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg"));
			}
		}
		logger.info("[WeixinUtil][get_oauth2_access_token_from_url][end]");
		return accessToken;
	}
	
	
	
}
