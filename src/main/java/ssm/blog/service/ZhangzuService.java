package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Zhangzu;
import ssm.blog.entity.ZhangzuAnalysis;
/**
 * @Description 
 * @author songml
 *
 */
public interface ZhangzuService {

	public List<Zhangzu> get_all();
	public List<Zhangzu> get_one_month_min(String ac);
	public List<Zhangzu> get_one_month_plus(String ac);
	
	public List<ZhangzuAnalysis> get_analysis_all(String ac);
	public Zhangzu get_one(Integer id);
	public Integer update(Zhangzu zhangzu);
	public Integer insert(Zhangzu zhangzu);
	public Integer delete(Zhangzu zhangzu);
	

}



