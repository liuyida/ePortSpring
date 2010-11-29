/**
 * 
 */
package com.xmhuanyu.eport.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @category 银行汇率表
 * @author Huanyu
 * 
 */
public class BankRate implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer seqno;
	private Date date;
	private double rate;	

	public BankRate() {
		super();
	}

	public BankRate(Date date, double rate) {
		super();
		this.date = date;
		this.rate = rate;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
