package ssm.blog.service;

import java.util.List;
import java.util.Map;

import ssm.blog.entity.BlogType;

/**
 * @Description 文章类别Service接口
 * @author Ni Shengwu
 *
 */
public interface BlogTypeService {

	public List<BlogType> getBlogTypeData();

	// 分页查询文章类别信息
	public List<BlogType> listBlogType(Map<String, Object> map);
	
	
	public BlogType findById(Integer i);
	// 获取总记录数
	public Long getTotal(Map<String, Object> map);
	
	// 添加文章类别
	public Integer addBlogType(BlogType blogType);
	
	// 更新文章类别
	public Integer updateBlogType(BlogType blogType);
	
	// 删除文章类别
	public Integer deleteBlogType(Integer id);
}
