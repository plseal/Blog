package ssm.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ssm.blog.entity.Zhangzu;
import ssm.blog.entity.ZhangzuAnalysis;
import ssm.blog.service.ZhangzuService;
import ssm.blog.dao.ZhangzuDao;

@Service("zhangzuService")
public class ZhangzuServiceImpl implements ZhangzuService {
	private static Logger logger = Logger.getLogger(ZhangzuServiceImpl.class);
	
	@Resource
	private ZhangzuDao zhangzudao;
	
	public List<Zhangzu> get_all(){
    	return zhangzudao.get_all();
    }
	public List<Zhangzu> get_one_month_min(String ac){
    	return zhangzudao.get_one_month_min(ac);
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
	public List<ZhangzuAnalysis> get_analysis_by_type(String ac){
    	return zhangzudao.get_analysis_by_type(ac);
    }
	
	public Zhangzu get_one(Integer id){
    	return zhangzudao.get_one(id);
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
