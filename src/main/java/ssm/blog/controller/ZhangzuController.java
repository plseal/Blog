package ssm.blog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.URLEncoder;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssm.blog.entity.Zhangzu;
import ssm.blog.entity.ZhangzuAnalysis;
import ssm.blog.lucene.BlogIndex;
import ssm.blog.service.BillService;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.CommentService;
import ssm.blog.service.ExpressService;
import ssm.blog.service.ZhangzuService;
/**
 * @Description 
 * @author songml
 *
 */
@Controller
@RequestMapping("/zhangzu")
public class ZhangzuController {
	private static Logger logger = Logger.getLogger(ZhangzuController.class);
	@Resource
	private BlogService blogService;
	@Resource
	private ZhangzuService zhangzuService;
	@Resource
	private BillService billService;
	@Resource
	private CommentService commentService;
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource(name="expressService")
	private ExpressService expressService;
	
	public static final int pagesize = 10;
	
	@Value("#{setting[STR1]}")
	private String STR1; 

	@Value("#{setting[STR2]}")
	private String STR2; 
	
	@Value("#{setting[STR3]}")
	private String STR3; 
	
	@Value("#{setting[STR4]}")
	private String STR4;
	
	private BlogIndex blogIndex = new BlogIndex();
	
	@RequestMapping("/to_index_zhangzu")
	public String to_index_zhangzu(
			String FLG,
			String AC,
			String IO,
			String AC_TYPE,
			String AC_TYPE_E,
			Zhangzu zhangzu,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_index_zhangzu][start]");
		logger.info("["+this.getClass()+"][to_index_zhangzu][FLG]"+FLG);
		logger.info("["+this.getClass()+"][to_index_zhangzu][AC]"+AC);
		logger.info("["+this.getClass()+"][to_index_zhangzu][IO]"+IO);
		logger.info("["+this.getClass()+"][to_index_zhangzu][AC_TYPE]"+AC_TYPE);
		logger.info("["+this.getClass()+"][to_index_zhangzu][AC_TYPE_E]"+AC_TYPE_E);
		List<Zhangzu> zhangzus=zhangzuService.get_all();
		if ("UPDATE".equals(FLG)) {
			zhangzuService.update(zhangzu);
		} else if ("INSERT".equals(FLG)){
			zhangzuService.insert(zhangzu);
		} else if ("DELETE".equals(FLG)){
			zhangzuService.delete(zhangzu);
		} else if ("2018".equals(FLG)){
			zhangzus = zhangzuService.get_2018();
		} else if ("2019".equals(FLG)){
			zhangzus = zhangzuService.get_2019();
		} else if ("2020".equals(FLG)){
			zhangzus = zhangzuService.get_2020();
		}else {
			if ("PLUS".equals(IO)) {
			     zhangzus = zhangzuService.get_one_month_plus(AC);
			}else if ("MIN".equals(IO)) {
				 
				 if(AC_TYPE_E != null){
					 logger.info("["+this.getClass()+"][to_index_zhangzu][AC_TYPE_E]"+URLDecoder.decode(AC_TYPE_E,"UTF-8"));
					 zhangzus = zhangzuService.get_one_month_min_type(AC,URLDecoder.decode(AC_TYPE_E,"UTF-8"));
				 }else{
					 zhangzus = zhangzuService.get_one_month_min(AC);
				 }
			}else if ("MAIHUO".equals(IO)) {
				 zhangzus = zhangzuService.get_one_month_maihuo(AC);

			
			}				
		}

		
		
		request.setAttribute("zhangzus", zhangzus);
		if ("".equals(AC)) {
			AC = "2018/02";
		}else{
			// do nothing
		}	
		request.setAttribute("INDEX_AC", AC);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_index_zhangzu][end] to index_zhangzu.jsp");
		return "../../zhangzu/index_zhangzu";
	}
	@RequestMapping("/get_one_zhangzu")
	public String get_one_zhangzu(
			String FLG,
			String Z_DATE,
			String Z_NAME,
			Zhangzu zhangzu,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][get_one_zhangzu][start]");
		logger.info("["+this.getClass()+"][get_one_zhangzu][Z_DATE]"+Z_DATE);
		logger.info("["+this.getClass()+"][get_one_zhangzu][Z_NAME]"+Z_NAME);
		List<Zhangzu> zhangzus = new ArrayList<Zhangzu>();
		if ("SELECT".equals(FLG)) {
			Zhangzu zz = zhangzuService.get_one_zhangzu(Z_DATE,Z_NAME);
			zhangzus.add(zz);
		}

		request.setAttribute("zhangzus", zhangzus);
		
		String AC = "2018/02";
		request.setAttribute("INDEX_AC", AC);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][get_one_zhangzu][end] to index_zhangzu.jsp");
		return "../../zhangzu/index_zhangzu";
	}
	@RequestMapping("/to_zhangzu_update")
	public String to_zhangzu_update(
			Integer id,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_update][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_update][id]"+id);

		Zhangzu zhangzu = zhangzuService.get_one(id);
		
		request.setAttribute("zhangzu", zhangzu);
		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_update][end] to zhangzu_update.jsp");
		return "../../zhangzu/zhangzu_update";
	}
	
	@RequestMapping("/to_zhangzu_insert")
	public String to_zhangzu_insert(
			Integer id,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_insert][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_insert][id]"+id);
		
		Zhangzu zhangzu = new Zhangzu();
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String todayyyyMMdd = df.format(date);
		
		zhangzu.setZ_date(todayyyyMMdd);
		
		request.setAttribute("zhangzu", zhangzu);
		
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_insert][end] to zhangzu_insert.jsp");
		return "../../zhangzu/zhangzu_insert";
	}
	
	@RequestMapping("/to_zhangzu_analysis")
	public String to_zhangzu_analysis(
			String zhangzu_ac,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_analysis][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_analysis][zhangzu_ac]"+zhangzu_ac);
		
		ZhangzuAnalysis zz_analysis;
		List<ZhangzuAnalysis> list1_zz_analysis;
		long ac_min ;
		long ac_plus ;
		long ac_result;
		long ac_maihuo;
		List<ZhangzuAnalysis> list_zz_analysis = new ArrayList<ZhangzuAnalysis>();
		
		zz_analysis = new ZhangzuAnalysis();
		list1_zz_analysis = zhangzuService.get_analysis_all(zhangzu_ac);
		ac_min = 0;
		ac_plus = 0;
		ac_result = 0;
		ac_maihuo = 0;
		//	2017/01	XXXX	0	    -911732	0  zhichu
		//	2017/01	XXXX	374334	0	    0
		//	2017/01	XXXX	0	    -911732	0  maihuo
		logger.info("["+this.getClass()+"][to_zhangzu_analysis][list1_zz_analysis.size()]"+list1_zz_analysis.size());
		for(int i = 0 ; i < list1_zz_analysis.size() ; i++) {
			if (i == 0 ) {
				ac_min = list1_zz_analysis.get(i).getAc_min();
			} else if (i == 1){
				ac_plus = list1_zz_analysis.get(i).getAc_plus();
			} else {
				ac_maihuo = list1_zz_analysis.get(i).getAc_min();
			}
		}
		ac_result = ac_plus + ac_min;
		zz_analysis.setAc(zhangzu_ac);
		zz_analysis.setAc_min(ac_min);
		zz_analysis.setAc_plus(ac_plus);
		zz_analysis.setAc_result(ac_result);
		zz_analysis.setAc_maihuo(ac_maihuo);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis][ac_maihuo]"+ac_maihuo);
		list_zz_analysis.add(zz_analysis);

		

		
		request.setAttribute("list_zz_analysis", list_zz_analysis);

		
		List<ZhangzuAnalysis> list_zz_type_analysis = new ArrayList<ZhangzuAnalysis>();
		zz_analysis = new ZhangzuAnalysis();
		list_zz_type_analysis = zhangzuService.get_analysis_by_type(zhangzu_ac);
		
		request.setAttribute("list_zz_type_analysis", list_zz_type_analysis);
		
		
		
		List<ZhangzuAnalysis> list_2018_zz_analysis = zhangzuService.get_analysis_2018();
		request.setAttribute("list_2018_zz_analysis", list_2018_zz_analysis);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis][end] to zhangzu_analysis.jsp");
		return "../../zhangzu/zhangzu_analysis";
	}
	
	
	@RequestMapping("/to_zhangzu_analysis_2019")
	public String to_zhangzu_analysis_2019(
			String zhangzu_ac,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2019][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2019][zhangzu_ac]"+zhangzu_ac);
		
		if ("".equals(zhangzu_ac)) {
			zhangzu_ac = "2019/01";
		}
		
		ZhangzuAnalysis zz_analysis;
		List<ZhangzuAnalysis> list1_zz_analysis;
		long ac_min ;
		long ac_plus ;
		long ac_result;
		long ac_maihuo;
		List<ZhangzuAnalysis> list_zz_analysis = new ArrayList<ZhangzuAnalysis>();
		
		zz_analysis = new ZhangzuAnalysis();
		list1_zz_analysis = zhangzuService.get_analysis_all(zhangzu_ac);
		ac_min = 0;
		ac_plus = 0;
		ac_result = 0;
		ac_maihuo = 0;
		//	2019/01	XXXX	0	    -911732	0  zhichu
		//	2019/01	XXXX	374334	0	    0
		//	2019/01	XXXX	0	    -911732	0  maihuo
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2019][list1_zz_analysis.size()]"+list1_zz_analysis.size());
		for(int i = 0 ; i < list1_zz_analysis.size() ; i++) {
			if (i == 0 ) {
				ac_min = list1_zz_analysis.get(i).getAc_min();
			} else if (i == 1){
				ac_plus = list1_zz_analysis.get(i).getAc_plus();
			} else {
				ac_maihuo = list1_zz_analysis.get(i).getAc_min();
			}
		}
		ac_result = ac_plus + ac_min;
		zz_analysis.setAc(zhangzu_ac);
		zz_analysis.setAc_min(ac_min);
		zz_analysis.setAc_plus(ac_plus);
		zz_analysis.setAc_result(ac_result);
		zz_analysis.setAc_maihuo(ac_maihuo);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2019][ac_maihuo]"+ac_maihuo);
		list_zz_analysis.add(zz_analysis);

		request.setAttribute("list_zz_analysis", list_zz_analysis);

		List<ZhangzuAnalysis> list_zz_type_analysis = new ArrayList<ZhangzuAnalysis>();
		zz_analysis = new ZhangzuAnalysis();
		list_zz_type_analysis = zhangzuService.get_analysis_by_type(zhangzu_ac);
		
		request.setAttribute("list_zz_type_analysis", list_zz_type_analysis);
		
		
		
		List<ZhangzuAnalysis> list_2019_zz_analysis = zhangzuService.get_analysis_2019();
		request.setAttribute("list_2019_zz_analysis", list_2019_zz_analysis);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2019][end] to zhangzu_analysis_2019.jsp");
		return "../../zhangzu/zhangzu_analysis_2019";
	}
	
	@RequestMapping("/to_zhangzu_analysis_2020")
	public String to_zhangzu_analysis_2020(
			String zhangzu_ac,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2020][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2020][zhangzu_ac]"+zhangzu_ac);
		
		if ("".equals(zhangzu_ac)) {
			zhangzu_ac = "2020/01";
		}
		
		ZhangzuAnalysis zz_analysis;
		List<ZhangzuAnalysis> list1_zz_analysis;
		long ac_min ;
		long ac_plus ;
		long ac_result;
		long ac_maihuo;
		List<ZhangzuAnalysis> list_zz_analysis = new ArrayList<ZhangzuAnalysis>();
		
		zz_analysis = new ZhangzuAnalysis();
		list1_zz_analysis = zhangzuService.get_analysis_all(zhangzu_ac);
		ac_min = 0;
		ac_plus = 0;
		ac_result = 0;
		ac_maihuo = 0;
		//	2020/01	XXXX	0	    -911732	0  zhichu
		//	2020/01	XXXX	374334	0	    0
		//	2020/01	XXXX	0	    -911732	0  maihuo
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2020][list1_zz_analysis.size()]"+list1_zz_analysis.size());
		for(int i = 0 ; i < list1_zz_analysis.size() ; i++) {
			if (i == 0 ) {
				ac_min = list1_zz_analysis.get(i).getAc_min();
			} else if (i == 1){
				ac_plus = list1_zz_analysis.get(i).getAc_plus();
			} else {
				ac_maihuo = list1_zz_analysis.get(i).getAc_min();
			}
		}
		ac_result = ac_plus + ac_min;
		zz_analysis.setAc(zhangzu_ac);
		zz_analysis.setAc_min(ac_min);
		zz_analysis.setAc_plus(ac_plus);
		zz_analysis.setAc_result(ac_result);
		zz_analysis.setAc_maihuo(ac_maihuo);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2020][ac_maihuo]"+ac_maihuo);
		list_zz_analysis.add(zz_analysis);

		request.setAttribute("list_zz_analysis", list_zz_analysis);

		List<ZhangzuAnalysis> list_zz_type_analysis = new ArrayList<ZhangzuAnalysis>();
		zz_analysis = new ZhangzuAnalysis();
		list_zz_type_analysis = zhangzuService.get_analysis_by_type(zhangzu_ac);
		
		request.setAttribute("list_zz_type_analysis", list_zz_type_analysis);
		
		
		
		List<ZhangzuAnalysis> list_2020_zz_analysis = zhangzuService.get_analysis_2020();
		request.setAttribute("list_2020_zz_analysis", list_2020_zz_analysis);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2020][end] to zhangzu_analysis_2020.jsp");
		return "../../zhangzu/zhangzu_analysis_2020";
	}
	
	@RequestMapping("/to_zhangzu_analysis_2021")
	public String to_zhangzu_analysis_2021(
			String zhangzu_ac,
			HttpServletRequest request) throws Exception {
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][start]");
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][zhangzu_ac]"+zhangzu_ac);
		
		if ("".equals(zhangzu_ac)) {
			zhangzu_ac = "2021/01";
		}
		
		ZhangzuAnalysis zz_analysis;
		List<ZhangzuAnalysis> list1_zz_analysis;
		long ac_min ;
		long ac_plus ;
		long ac_result;
		long ac_maihuo;
		List<ZhangzuAnalysis> list_zz_analysis = new ArrayList<ZhangzuAnalysis>();
		
		zz_analysis = new ZhangzuAnalysis();
		list1_zz_analysis = zhangzuService.get_analysis_all(zhangzu_ac);
		ac_min = 0;
		ac_plus = 0;
		ac_result = 0;
		ac_maihuo = 0;
		//	2021/01	XXXX	0	    -911732	0  zhichu
		//	2021/01	XXXX	374334	0	    0
		//	2021/01	XXXX	0	    -911732	0  maihuo
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][list1_zz_analysis.size()]"+list1_zz_analysis.size());
		for(int i = 0 ; i < list1_zz_analysis.size() ; i++) {
			if (i == 0 ) {
				ac_min = list1_zz_analysis.get(i).getAc_min();
			} else if (i == 1){
				ac_plus = list1_zz_analysis.get(i).getAc_plus();
			} else {
				ac_maihuo = list1_zz_analysis.get(i).getAc_min();
			}
		}
		ac_result = ac_plus + ac_min;
		zz_analysis.setAc(zhangzu_ac);
		zz_analysis.setAc_min(ac_min);
		zz_analysis.setAc_plus(ac_plus);
		zz_analysis.setAc_result(ac_result);
		zz_analysis.setAc_maihuo(ac_maihuo);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][ac_maihuo]"+ac_maihuo);
		list_zz_analysis.add(zz_analysis);

		request.setAttribute("list_zz_analysis", list_zz_analysis);

		List<ZhangzuAnalysis> list_zz_type_analysis = new ArrayList<ZhangzuAnalysis>();
		zz_analysis = new ZhangzuAnalysis();
		list_zz_type_analysis = zhangzuService.get_analysis_by_type(zhangzu_ac);
		
		String strAcTypeE;
		for(int i = 0 ; i < list_zz_type_analysis.size() ; i++) {
			strAcTypeE = URLEncoder.encode(list_zz_type_analysis.get(i).getAc_type(),"UTF-8");
			logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][strAcTypeE]"+strAcTypeE);
			list_zz_type_analysis.get(i).setAc_type_e(strAcTypeE);
		}
		request.setAttribute("list_zz_type_analysis", list_zz_type_analysis);
		
		
		
		List<ZhangzuAnalysis> list_2021_zz_analysis = zhangzuService.get_analysis_2021();
		request.setAttribute("list_2021_zz_analysis", list_2021_zz_analysis);
		//ResponseUtil.write(response, result);
		logger.info("["+this.getClass()+"][to_zhangzu_analysis_2021][end] to zhangzu_analysis_2021.jsp");
		return "../../zhangzu/zhangzu_analysis_2021";
	}
}
