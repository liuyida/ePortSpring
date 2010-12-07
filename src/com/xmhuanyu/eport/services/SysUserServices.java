package com.xmhuanyu.eport.services;



import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.xmhuanyu.eport.entity.SysUser;

/**
 * @category SysUser数据服务
 * @author EDA
 *
 */
@Named("userServices")
public class SysUserServices extends InjectSessionFactory{
	public void addSysUser(SysUser sysUser){			
		Session session=getSession();
		session.beginTransaction().begin();
		session.persist(sysUser);
		session.beginTransaction().commit();
		session.flush();
		session.close();
	}
	
	public SysUser getSysUserByLoginId(String loginName){
		return (SysUser) getSession().createCriteria(SysUser.class)
				.add(Restrictions.eq("loginName", loginName)).uniqueResult();
	}
	
	public void changeLoginTime(SysUser user){
		Session session=getSession();
		session.beginTransaction().begin();
		session.update(user);
		session.beginTransaction().commit();
		session.flush();
		session.close();
	}

}
