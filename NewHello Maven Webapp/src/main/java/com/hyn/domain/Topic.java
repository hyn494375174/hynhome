package com.hyn.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "t_topic")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class Topic extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private int topicId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "topic_title")
	private String topicTitle;

	@Column(name = "topic_text")
	private String topicText;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "topic_view")
	private int topic_view;
	
	@Column(name = "topic_reply")
	private int topic_reply;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicText() {
		return topicText;
	}

	public void setTopicText(String topicText) {
		this.topicText = topicText;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getTopic_view() {
		return topic_view;
	}

	public void setTopic_view(int topic_view) {
		this.topic_view = topic_view;
	}

	public int getTopic_reply() {
		return topic_reply;
	}

	public void setTopic_reply(int topic_reply) {
		this.topic_reply = topic_reply;
	}
	



}
