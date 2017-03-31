package ssm.blog.dao;

import ssm.blog.entity.AccessToken;

public interface AccessTokenDao {




	public AccessToken getAccessToken(Integer id);


	public Integer update(AccessToken at);

	
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
