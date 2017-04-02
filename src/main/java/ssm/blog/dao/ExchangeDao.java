package ssm.blog.dao;

import ssm.blog.entity.Exchange;

public interface ExchangeDao {




	public Exchange getExchange(Integer id);


	public Integer update(Exchange ex);

	
}
/*
@Component("accessTokenDao")
public class AccessTokenDao extends BaseDao {

	
	public AccessToken getAccessToken(int id) {
		return this.readSqlSession.selectOne("ssm.blog.dao.AccessTokenDao.getAccessToken",id);
	}
	
	public void updateAccessToken(AccessToken accessToken){
		writerSqlSession.update("ssm.blog.dao.AccessTokenDao.updateAccessToken", accessToken);
	}
}
*/
