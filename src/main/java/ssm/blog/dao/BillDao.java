package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Bill;

public interface BillDao {




	public List<Bill> get_all();
	public List<Bill> get_finish();
	public List<Bill> get_not_finished();
	public Bill get_one(Integer id);
	public Integer update(Bill bill);
	public Integer insert(Bill bill);
	
	
}

