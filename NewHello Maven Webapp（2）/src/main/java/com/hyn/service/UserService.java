package com.hyn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyn.dao.LoginLogDao;
import com.hyn.dao.UserDao;
import com.hyn.domain.LoginLog;
import com.hyn.domain.User;
import com.hyn.exception.UserExistException;


@Transactional
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	public void register(User user) throws UserExistException{
		User u = this.getUserByUserName(user.getUser_name());
		if(u != null){
			throw new UserExistException("用户名已经存在!");
		}else{
			user.setUser_type(1);
			userDao.save(user);
		}
	}
	
	/**
	 * 根据用户名密码查询User对象
	 * @param userName 查询用户名
	 * @return userName匹配的User对象
	 */
	public User getUserByUserName(String userName){
		return userDao.getUserByUserName(userName);
	}
	
	/**
	 * 根据用户id查找User对象
	 * @param userId 查询用户Id
	 * @return Id=userId的User对象
	 */
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	
	/**
	 * 根据用户名为条件，执行模糊查询操作 
	 * @param userName 查询用户名
	 * @return 所有用户名前导匹配的userName的用户
	 */
	public List<User> queryUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	/**
	 * 获取所有用户
	 * @return 所有用户
	 */
	public List<User> getAllUsers(){
		return userDao.loadAll();
	}
	
	/**
	 * 登陆成功
	 * @param user
	 */
	public void loginSuccess(User user) {
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setLoginDate(new Date());
        userDao.update(user);
        loginLogDao.save(loginLog);
	}	
}
