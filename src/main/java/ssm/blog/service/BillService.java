package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Bill;

/**
 * @Description 
 * @author songml
 *
 */
public interface BillService {

	public List<Bill> get_all();
	public List<Bill> get_finish();
	public List<Bill> get_not_finished();
	public Bill get_one(Integer id);
	public Integer update(Bill bill);
	public Integer insert(Bill bill);
	

}



