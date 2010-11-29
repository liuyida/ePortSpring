package com.xmhuanyu.eport.entity;

import java.util.Date;

/**
 * @category 银行汇率表 美元对人民币
 * @author EDA
 * 
 */
public class BankRate {
	private Integer seqno;
	private Date rateDate;
	private double rate;

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public Date getRateDate() {
		return rateDate;
	}

	public void setRateDate(Date rateDate) {
		this.rateDate = rateDate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
