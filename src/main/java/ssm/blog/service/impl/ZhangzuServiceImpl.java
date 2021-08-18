package ssm.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.blog.entity.Zhangzu;
import ssm.blog.entity.ZhangzuAnalysis;
import ssm.blog.service.ZhangzuService;
import ssm.blog.dao.ZhangzuDao;

@Service("zhangzuService")
public class ZhangzuServiceImpl implements ZhangzuService {
	
	@Resource
	private ZhangzuDao zhangzudao;
	
	public List<Zhangzu> get_all(){
    	return zhangzudao.get_all();
    }
	public List<Zhangzu> get_2018(){
    	return zhangzudao.get_2018();
    }
	public List<Zhangzu> get_2019(){
    	return zhangzudao.get_2019();
    }	
	public List<Zhangzu> get_2020(){
    	return zhangzudao.get_2020();
    }	
	public List<Zhangzu> get_one_month_min(String ac){
    	return zhangzudao.get_one_month_min(ac);
    }
	public List<Zhangzu> get_one_month_min_type(String ac,String ac_type){
    	return zhangzudao.get_one_month_min_type(ac,ac_type);
    }
	public List<Zhangzu> get_one_month_plus(String ac){
    	return zhangzudao.get_one_month_plus(ac);
    }

	public List<Zhangzu> get_one_month_maihuo(String ac){
    	return zhangzudao.get_one_month_maihuo(ac);
    }


	public List<ZhangzuAnalysis> get_analysis_all(String ac){
    	return zhangzudao.get_analysis_all(ac);
    }
	public List<ZhangzuAnalysis> get_analysis_2018(){
    	return zhangzudao.get_analysis_2018();
    }
	public List<ZhangzuAnalysis> get_analysis_2019(){
    	return zhangzudao.get_analysis_2019();
    }
	public List<ZhangzuAnalysis> get_analysis_2020(){
    	return zhangzudao.get_analysis_2020();
    }
	public List<ZhangzuAnalysis> get_analysis_2021(){
    	return zhangzudao.get_analysis_2021();
    }
	public List<ZhangzuAnalysis> get_analysis_by_type(String ac){
    	return zhangzudao.get_analysis_by_type(ac);
    }
	
	public Zhangzu get_one(Integer id){
    	return zhangzudao.get_one(id);
    }
	public Zhangzu get_one_zhangzu(String z_date,String z_name){
    	return zhangzudao.get_one_zhangzu(z_date,z_name);
    }
	public Integer update(Zhangzu zhangzu){
		
    	return zhangzudao.update(zhangzu);
    }

	public Integer insert(Zhangzu zhangzu){
		
    	return zhangzudao.insert(zhangzu);
    }
	public Integer delete(Zhangzu zhangzu){
		
    	return zhangzudao.delete(zhangzu);
    }
	
}
