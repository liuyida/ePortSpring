package com.xmhuanyu.eport.services;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.xmhuanyu.eport.entity.BankRate;

/**
 * @category 银行汇率表数据库操作
 * @author Huanyu
 *
 */
public class BankRateServices extends InjectSessionFactory{
	public BankRate getBankRateByDate(Date date){ 
		Session session=getSession();
		return (BankRate) session.createCriteria(BankRate.class).add(Restrictions.eq("date", date)).uniqueResult();
	}
	
	public void addBankRate(BankRate bankRate){
		
	}

}
