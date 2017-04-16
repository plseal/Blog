package ssm.blog.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ssm.blog.entity.ChildHealthRecord;
import ssm.blog.entity.Message;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.ChildHealthRecordService;
import ssm.blog.util.WeixinUtil;

/**
 * @Description Controller
 * @author songml
 *
 */
@Controller
@RequestMapping("/child_health_record")
public class ChildHealthRecordController {
	private static Logger logger = Logger.getLogger(ChildHealthRecordController.class);
	@Resource
	private ChildHealthRecordService childHealthRecord;
	@Resource
	private BlogTypeService blogTypeService;
	/**
	 * @Description 
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "typeId", required = false) String typeId,
			@RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
			HttpServletRequest request) throws Exception {
		
		logger.info("["+this.getClass()+"][detail][start]");
		
		ModelAndView modelAndView = new ModelAndView();
		//String weixin_openid ="test_o08GJwa_rYPdbwV6jDi2ZTaXyJ6s";
		/*
		Map<String, String> requestMap = WeixinUtil.parseXml(request);
		Message message = WeixinUtil.mapToMessage(requestMap);
		String  weixin_openid = message.getFromUserName();
		logger.info("["+this.getClass().getName()+"][detail][weixin_openid]"+weixin_openid);
		
		modelAndView.addObject("title", "home");
		
		
		ChildHealthRecord chr = new ChildHealthRecord();
		chr.setWeixin_openid(weixin_openid);
		chr.setChild_name(request.getParameter("child_name"));
		chr.setChild_sex(request.getParameter("child_sex"));
		chr.setChild_birth(request.getParameter("hid_child_birth"));
		chr.setChild_age(request.getParameter("child_age"));
		chr.setChild_height(request.getParameter("child_height"));
		chr.setChild_weight(request.getParameter("child_weight"));
		
		childHealthRecord.insert_chr(chr);
		*/
		modelAndView.setViewName("child_health_record_detail");
		
		
		
		logger.info("["+this.getClass()+"][detail][end]");
		return modelAndView;

	}

}
