package ssm.blog.service;

import ssm.blog.entity.ChildHealthRecord;

/**
 * @Description 
 * @author songml
 *
 */
public interface ChildHealthRecordService {

	public ChildHealthRecord get_chr(ChildHealthRecord chr);
	public Integer update_chr(ChildHealthRecord chr);
	public Integer insert_chr(ChildHealthRecord chr);

}
