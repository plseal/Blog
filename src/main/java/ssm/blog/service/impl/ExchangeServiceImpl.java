package ssm.blog.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ssm.blog.dao.ExchangeDao;
import ssm.blog.entity.Exchange;
import ssm.blog.service.ExchangeService;
import ssm.blog.util.WeixinUtil;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
/**
 * @Description 
 * @author songml
 *
 */
@Service("exchangeService")
public class ExchangeServiceImpl implements ExchangeService {
	
	private static Logger logger = Logger.getLogger(ExchangeService.class);
	
	@Resource(name="exchangeDao")
	private ExchangeDao exchangeDao;
	
	
	@Value("#{setting[NOWAPI_APPKEY]}")
	private String str_nowapi_appkey; 
	
	@Value("#{setting[NOWAPI_SIGN]}")
	private String str_nowapi_sign; 
	
	/**
	 * 获取access_token
	 * 
	 * @param appid 凭证
	 * @param appsecret 密钥
	 * @return
	 * @throws IOException 
	 */
	public Exchange getExchange() throws IOException {
		
		logger.info("["+this.getClass().getName()+"][getExchange][start]");
		Exchange ex = null;
		
		//先从DB查找accessToken，存在并且没有过期的话，就不用去服务器取了
		
		ex = exchangeDao.getExchange(1);

		//int _in = Integer.parseInt(accessToken.getExpires_in());
		long create_time = ex.getCreate_time();
		//72刷新一次
		//if ((System.currentTimeMillis()-create_time)/1000 < 72) {// 有效
		//	logger.info("["+this.getClass().getName()+"][getExchange][Get From URL is not necessary]");
			
		//过期的话，需要去服务器再取一次
		//} else {
			//System.out.println("无效重新创建");
			
			//String str_url = "http://api.k780.com:88/?app=finance.rate_cnyquot&curno=JPY&&appkey=NOWAPI_APPKEY&sign=NOWAPI_SIGN&format=json";
			//String str_url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22JPYCNY%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
			//String str_url = "https://api.fixer.io/latest?base=JPY";
			//2018/06/11
			String str_url = "https://forex.1forge.com/1.0.3/quotes?pairs=JPYCNH&api_key=y9m0rFBJsgrPAYoMJ4aVxGQEiKImI7yE";
	        //String requestUrl = str_url.replace("NOWAPI_APPKEY", str_nowapi_appkey);
	        //       requestUrl = requestUrl.replace("NOWAPI_SIGN", str_nowapi_sign);
	        logger.info("["+this.getClass().getName()+"][getExchange][str_url]"+str_url); 
	        
			
			
			JSONObject jsonObject = WeixinUtil.httpHUILVRequest(str_url, "GET", null);
			
			//-----------http http http 
			//String result =null;
			//JSONObject jsonObject =null;
			//Map params = new HashMap();//请求参数
	        //    params.put("access_key","bbbd64f7dce524c0a731bce1147587aa");
	            
			//try {
			//	result =JUHEUtil.net(str_url, params, "GET");
			//	//logger.info("result-----"+result);
			//	jsonObject = JSONObject.fromObject(result);
	        //} catch (Exception e) {
	        //    e.printStackTrace();
	        //}
			//-----------http http http 
			
			String strResult = "";
			// 如果请求成功
			if (null != jsonObject) {
				try {
					
					strResult =jsonObject.getString("price");
					
				} catch (JSONException e) {
					
					// 获取失败
					logger.info("GET INFO ERROR !!!");
				}
			}
			
			
			
			
	        
	        logger.info("["+this.getClass().getName()+"][getExchange][strResult]"+strResult);
			
			ex.setExchange(strResult);
			ex.setExpires_in(System.currentTimeMillis());
			
			ex.setCreate_time(System.currentTimeMillis());
			
			update(ex);//更新数据库
		//}
		
		logger.info("["+this.getClass().getName()+"][getExchange][end]");
		return ex;
	}

	public Integer update(Exchange ex){
		return exchangeDao.update(ex);//更新数据库
	}
	


}
