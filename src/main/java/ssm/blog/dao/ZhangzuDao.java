package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Zhangzu;
import ssm.blog.entity.ZhangzuAnalysis;

public interface ZhangzuDao {




	public List<Zhangzu> get_all();
	public List<Zhangzu> get_2018();
	public List<Zhangzu> get_2019();
	public List<Zhangzu> get_2020();
	public List<Zhangzu> get_one_month_min(String ac);
	public List<Zhangzu> get_one_month_min_type(String ac,String ac_type);
	public List<Zhangzu> get_one_month_plus(String ac);
	public List<Zhangzu> get_one_month_maihuo(String ac);
	
	
	public List<ZhangzuAnalysis> get_analysis_all(String ac);
	public List<ZhangzuAnalysis> get_analysis_by_type(String ac);
	public List<ZhangzuAnalysis> get_analysis_2018();
	public List<ZhangzuAnalysis> get_analysis_2019();
	public List<ZhangzuAnalysis> get_analysis_2020();
	public List<ZhangzuAnalysis> get_analysis_2021();
	
	public Zhangzu get_one(Integer id);
	public Zhangzu get_one_zhangzu(String z_date,String z_name);
	public Integer update(Zhangzu zhangzu);
	public Integer insert(Zhangzu zhangzu);
	public Integer delete(Zhangzu zhangzu);
	
}

