package com.hyn.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author hyn
 *
 */

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_user")
public class User extends BaseDomain{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;		//用户ID
	
	@Column(name = "user_name")
	private String user_name;	//用户名
	
	@Column(name = "password")
	private String password;	//密码
	
	@Column(name = "user_type")
	private int user_type;		//用户类型
	
	@Column(name = "last_visit")
	private Date last_visit;	//用户最后一次登录
	
	@Column(name = "last_ip")
	private String last_ip;		//用户最后一次登录IP
	
	@Column(name = "active_staus")
	private int active_staus;	//激活状态
	
	@Column(name = "active_core")
	private String active_core;	//激活码
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public Date getLast_visit() {
		return last_visit;
	}
	public void setLast_visit(Date last_visit) {
		this.last_visit = last_visit;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	public int getActive_staus() {
		return active_staus;
	}
	public void setActive_staus(int active_staus) {
		this.active_staus = active_staus;
	}
	public String getActive_core() {
		return active_core;
	}
	public void setActive_core(String active_core) {
		this.active_core = active_core;
	}
}
