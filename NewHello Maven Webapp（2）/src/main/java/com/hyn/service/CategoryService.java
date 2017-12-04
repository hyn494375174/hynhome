package com.hyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyn.dao.CategoryDao;
import com.hyn.domain.Category;



@Transactional
@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categorydao;
	
	/**
	 * 创建一个新的分类
	 * 
	 * @param category
	 */
	public void addCategory(Category category){
		categorydao.save(category);
	}
	
	/**
	 * 删除一个分类，当分类有文章时无法删除
	 * 
	 * @param CategoryId
	 */
	public void removeCategory(int CategoryId){
		Category category = categorydao.get(CategoryId);
		categorydao.remove(category);
	}
	
	/**
     * 获取所有的分类
     * @return
     */
    public List<Category> getAllBoards(){
        return categorydao.loadAll();
    }	
    
    /**
	 * 根据CategoryId获取Category对象
	 * 
	 * @param boardId
	 */
	public Category getBoardById(int CategoryId) {
		return categorydao.get(CategoryId);
	}
	
	/**
	 * 更改分类名称
	 * @param topic
	 */
	public void updateTopic(Category category){
		categorydao.update(category);
	}
}
