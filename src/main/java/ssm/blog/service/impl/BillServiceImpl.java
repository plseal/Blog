package ssm.blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ssm.blog.entity.Bill;
import ssm.blog.service.BillService;
import ssm.blog.dao.BillDao;

@Service("billService")
public class BillServiceImpl implements BillService {
	private static Logger logger = Logger.getLogger(BillServiceImpl.class);
	
	@Resource
	private BillDao billDao;
	
	public List<Bill> get_all(){
    	return billDao.get_all();
    }
	public Bill get_one(Integer id){
    	return billDao.get_one(id);
    }
	public Integer update(Bill bill){

    	return billDao.update(bill);


    }

	public Integer insert(Bill bill){

    	return billDao.insert(bill);


    }
	
	
}
