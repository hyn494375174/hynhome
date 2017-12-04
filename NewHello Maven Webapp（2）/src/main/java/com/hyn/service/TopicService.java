package com.hyn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyn.dao.TopicDao;
import com.hyn.domain.Topic;

@Transactional
@Service
public class TopicService {
	
	@Autowired
	private TopicDao topicdao;
	
	/**
	 * 创建一个新的文章
	 * 
	 * @param category
	 */
	public void addTopic(Topic topic){
		topicdao.save(topic);
	}
	
	/**
	 * 删除一篇文章
	 * 
	 * @param TopicId
	 */
	public void removeTopic(int TopicId){
		Topic topic = topicdao.get(TopicId);
		topicdao.remove(topic);
	}
	
	/**
     * 获取所有的文章
     * @return
     */
    public List<Topic> getAllBoards(){
        return topicdao.loadAll();
    }	
    
    /**
	 * 根据TopicId获取Topic对象
	 * 
	 * @param boardId
	 */
	public Topic getBoardById(int topicId) {
		return topicdao.get(topicId);
	}
	
	/**
	 * 更改文章名称
	 * @param topic
	 */
	public void updateTopic(Topic topic){
		topicdao.update(topic);
	}
}