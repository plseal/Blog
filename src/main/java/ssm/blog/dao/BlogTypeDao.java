package ssm.blog.dao;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.BlogType;

/**
 * @Description �������dao�ӿ�
 * @author songml
 *
 */
public interface BlogTypeDao {

	// ��ȡ���������Ϣ
	public List<BlogType> getBlogTypeData();

	// ����id��������������Ϣ
	public BlogType findById(Integer id);

	// ��ҳ��ѯ���������Ϣ
	public List<BlogType> listBlogType(Map<String, Object> map);
	
	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);
	
	// ����������
	public Integer addBlogType(BlogType blogType);
	
	// �����������
	public Integer updateBlogType(BlogType blogType);
	
	// ɾ���������
	public Integer deleteBlogType(Integer id);

}
