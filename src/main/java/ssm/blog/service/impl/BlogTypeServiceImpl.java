package ssm.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssm.blog.dao.BlogTypeDao;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;

/**
 * @Description 文章类别Service实现类
 * @author songml
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	
	@Resource
	private BlogTypeDao blogTypeDao;

	//获取文章类别信息
	public List<BlogType> getBlogTypeData() {
		
		return blogTypeDao.getBlogTypeData();
	}

	public BlogType findById(Integer id) {
		return blogTypeDao.findById(id);
	};
	
	public List<BlogType> listBlogType(Map<String, Object> map) {
		return blogTypeDao.listBlogType(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return blogTypeDao.getTotal(map);
	}

	public Integer addBlogType(BlogType blogType) {
		return blogTypeDao.addBlogType(blogType);
	}

	public Integer updateBlogType(BlogType blogType) {
		return blogTypeDao.updateBlogType(blogType);
	}

	public Integer deleteBlogType(Integer id) {
		return blogTypeDao.deleteBlogType(id);
	}

}
