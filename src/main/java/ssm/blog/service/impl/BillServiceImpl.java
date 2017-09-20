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
		Bill Bill2 = cal_percent(bill);
    	return billDao.update(Bill2);
    }

	public Integer insert(Bill bill){
		Bill Bill2 = cal_percent(bill);
    	return billDao.insert(Bill2);
    }
	public Bill cal_percent(Bill bill){
		if ("接到活儿".equals(bill.getBill_status())){
			bill.setBill_percent("10%");
		} else if ("已交定金".equals(bill.getBill_status())){
			bill.setBill_percent("20%");
		} else if ("已经发片".equals(bill.getBill_status())){
			bill.setBill_percent("30%");
		} else if ("上机印刷".equals(bill.getBill_status())){
			bill.setBill_percent("40%");
		} else if ("等待交货".equals(bill.getBill_status())){
			bill.setBill_percent("60%");
		} else if ("已经交货".equals(bill.getBill_status())){
			bill.setBill_percent("80%");
		} else if ("尾款结清".equals(bill.getBill_status())){
			bill.setBill_percent("100%");
		}
    	return bill;
    }
	
}
