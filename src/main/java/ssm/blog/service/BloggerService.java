package ssm.blog.service;

import ssm.blog.entity.Blogger;

/**
 * @Description ����Service�ӿ�
 * @author songml
 *
 */
public interface BloggerService {

	public Blogger getByUsername(String username);

	public Blogger getBloggerData();

	// ���²���������Ϣ
	public Integer updateBlogger(Blogger blogger);
}
