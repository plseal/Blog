package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Express;

public interface ExpressDao {




	public List<Express> get_by_name(String name);
	public List<Express> get_by_number(String number);
	public Integer update(Express ep);
	public Integer insert(Express ep);

	
}

