package com.hyn.dao;


import org.springframework.stereotype.Repository;

import com.hyn.domain.LoginLog;

/**
 * LoginLog的DAO类
 *
 */

@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
	public void save(LoginLog loginLog) {
		this.getHibernateTemplate().save(loginLog);
	}

}
