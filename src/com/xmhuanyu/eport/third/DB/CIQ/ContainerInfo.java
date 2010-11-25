package com.xmhuanyu.eport.third.DB.CIQ;

import java.io.Serializable;

/**
 * @category 集装箱信息
 * @author 刘毅达
 * 
 */
public class ContainerInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String declNO;
	private String model;
	private int qty;
	private String conDode;

	
	
	public ContainerInfo(int qty, String conDode) {
		super();
		this.qty = qty;
		this.conDode = conDode;
	}	
	
	public ContainerInfo() {
		super();
	}

	public String getConDode() {
		return conDode;
	}

	public void setConDode(String conDode) {
		this.conDode = conDode;
	}

	public String getDeclNO() {
		return declNO;
	}

	public void setDeclNO(String declNO) {
		this.declNO = declNO;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
