package ssm.blog.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

import ssm.blog.util.PageUtil;
import ssm.blog.util.ResponseUtil;
import ssm.blog.util.StringUtil;
import ssm.blog.entity.Family;
import ssm.blog.service.FamilyService;
/**
 * @Description 
 * @author songml
 *
 */
@Controller
@RequestMapping("/family")
public class FamilyController {
	private static Logger logger = Logger.getLogger(FamilyController.class);

	
	@Resource(name="familyService")
	private FamilyService familyService;
	
	public static final int pagesize = 10;
	
	@Value("#{setting[STR1]}")
	private String STR1; 

	@Value("#{setting[STR2]}")
	private String STR2; 
	
	@Value("#{setting[STR3]}")
	private String STR3; 
	
	@Value("#{setting[STR4]}")
	private String STR4;
	
	
	@RequestMapping("/get_all")
	public String get_all(
			String c_name,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][get_all][start]");
		

		List<Family> families = familyService.get_all();
		
		request.setAttribute("families", families);
		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][get_all][end]");
		return "../../family/main";
	}
	
	

	
}
