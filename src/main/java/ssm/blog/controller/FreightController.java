package ssm.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.ExchangeService;

/**
 * @Description Controller
 * @author songml
 *
 */
@Controller
@RequestMapping("/freight")
public class FreightController {
	private static Logger logger = Logger.getLogger(FreightController.class);
	@Resource
	private BlogService blogService;
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource(name="exchangeService")
	private ExchangeService exchangeService;
	
	/**
	 * @Description 
	 * @return
	 */
	@RequestMapping("/calculate")
	public ModelAndView calculate(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception {
		
		logger.info("["+this.getClass()+"][calculate][start]");
		
		
		
		
		
        String strResult = exchangeService.getExchange().getExchange();
        
        String banknm ="";
        String se_sell ="";
		Double double_se_sell ;
        
        JSONObject jsonObj;
		//logger.info("["+this.getClass()+"][calculate][strResult]"+strResult);
        //jsonObj  = JSONObject.fromObject(strResult);
        //if ("1".equals(jsonObj.getString("count"))) {
        	
        	
        	//System.out.println(jsonObj.getString("results"));
        	//JSONObject jsonObj2;
        	//jsonObj2 = JSONObject.fromObject(jsonObj.getString("results"));
        	//System.out.println(jsonObj2.getString("results"));
        	//JSONObject jsonObj3;
        	//jsonObj3 = JSONObject.fromObject(jsonObj2.getString("rate"));
        	//System.out.println(jsonObj3.getString("rate"));
        	//JSONObject jsonObj4;
        	//jsonObj4 = JSONObject.fromObject(jsonObj3.getString("rate"));
        	//System.out.println(jsonObj4.getString("banknm"));
        	
        	//banknm = jsonObj4.getString("Ask");
        	//se_sell = jsonObj.getString("CNY");
			double_se_sell = Double.valueOf(strResult) * 100;
			se_sell = Double.toString(double_se_sell);
        	System.out.println( se_sell);
        //}
		
		
		
		
		ModelAndView modelAndView = new ModelAndView();

		
		
		
		
		
		
		
		modelAndView.addObject("banknm", banknm);
		modelAndView.addObject("se_sell", se_sell);
		modelAndView.setViewName("freight");
		
		
		
		
		
		logger.info("["+this.getClass()+"][calculate][end]");
		return modelAndView;

	}

}
