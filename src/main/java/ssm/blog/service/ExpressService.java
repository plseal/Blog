package ssm.blog.service;

import java.util.List;

import ssm.blog.entity.Express;

/**
 * @Description 
 * @author songml
 *
 */
public interface ExpressService {

	public List<Express> get_by_number(String number);
	public List<Express> get_by_name(String name);
	public Integer update(Express expresses);
	public Integer insert(Express expresses);
	

}



