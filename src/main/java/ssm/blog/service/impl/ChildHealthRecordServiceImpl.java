package ssm.blog.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ssm.blog.dao.ChildHealthRecordDao;
import ssm.blog.entity.ChildHealthRecord;
import ssm.blog.service.ChildHealthRecordService;

/**
 * @Description 
 * @author songml
 *
 */
@Service("childHealthRecordService")
public class ChildHealthRecordServiceImpl implements ChildHealthRecordService {

	private static Logger logger = Logger.getLogger(ChildHealthRecordService.class);
	
	@Resource(name="childHealthRecordDao")
	private ChildHealthRecordDao childHealthRecordDao;
	


	public ChildHealthRecord get_chr(ChildHealthRecord chr) {
		
		logger.info("["+this.getClass().getName()+"][get_chr][start]");
		ChildHealthRecord childHealthRecord = null;
		//childHealthRecord.setWeixin_openid(weixin_openid);
		childHealthRecord = childHealthRecordDao.get_chr(childHealthRecord);

		//int _in = Integer.parseInt(accessToken.getExpires_in());
		
		
		logger.info("["+this.getClass().getName()+"][get_chr][end]");
		return childHealthRecord;
	}

	public Integer update_chr(ChildHealthRecord chr){
		return childHealthRecordDao.update_chr(chr);//更新数据库
	}

	public Integer insert_chr(ChildHealthRecord chr){
		return childHealthRecordDao.insert_chr(chr);//insert数据库
	}


}
