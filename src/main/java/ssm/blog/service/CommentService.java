package ssm.blog.service;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.Comment;

/**
 * @Description �û�����service�ӿ�
 * @author songml
 *
 */
public interface CommentService {

	// ��ȡ������Ϣ
	public List<Comment> getCommentData(Map<String, Object> map);

	// �������
	public int addComment(Comment comment);

	// ��ȡ�ܼ�¼��
	public Long getTotal(Map<String, Object> map);

	// �޸�������Ϣ
	public Integer update(Comment comment);

	// ɾ��������Ϣ
	public Integer deleteComment(Integer id);

	// ��������idɾ��������Ϣ������ɾ��ĳƪ����ǰ����ɾ�������µ����ۣ���Ϊ�����
	public Integer deleteCommentByBlogId(Integer blogId);
}
