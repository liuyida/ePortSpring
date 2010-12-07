package com.xmhuanyu.eport.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xmhuanyu.eport.entity.Employee;

/**
 * @category 员工数据库服务
 * @author EDA
 * 
 */
public class EmployeeServices extends InjectSessionFactory {

	public void addEmployee(Employee emp) {
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		session.persist(emp);
		trans.commit();
		session.flush();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList(int first,int pageSize){
		Query query=getSession().createQuery("from Employee as emp");
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		return query.list();		
	}
}
