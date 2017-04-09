package ssm.blog.dao;

import ssm.blog.entity.ChildHealthRecord;

public interface ChildHealthRecordDao {


	public ChildHealthRecord get_chr(ChildHealthRecord chr);

	public Integer update_chr(ChildHealthRecord chr);

    public Integer insert_chr(ChildHealthRecord chr);
}

