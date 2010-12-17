package com.xmhuanyu.eport.services;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xmhuanyu.eport.entity.BankRate;

/**
 * @category 银行汇率表数据库操作
 * @author Huanyu
 *
 */
@Repository("bankRateServices")
public class BankRateServices extends InjectSessionFactory{
	public BankRate getBankRateByDate(Date date){ 
		Session session=getSession();
		return (BankRate) session.createCriteria(BankRate.class).add(Restrictions.eq("date", date)).uniqueResult();
	}
	
	public void addBankRate(BankRate bankRate){
		Session session=getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		session.persist(bankRate);
		trans.commit();
		session.flush();
		session.close();
		
	}

}
