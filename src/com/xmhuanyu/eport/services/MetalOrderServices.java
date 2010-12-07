/**
 * 
 */
package com.xmhuanyu.eport.services;

import org.hibernate.Session;

import com.xmhuanyu.eport.entity.OrderInfo;

/**
 * @category 旧航材业务数据库操作
 * @author Huanyu
 * 
 */
public class MetalOrderServices extends InjectSessionFactory {
	public void saveMetalOrder(OrderInfo orderInfo) {
		Session session = getSession();
		session.beginTransaction().begin();
		session.persist(orderInfo);
		session.beginTransaction().commit();
		session.flush();
		session.close();
	}

}
