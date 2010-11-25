package com.xmhuanyu.eport.third.DB.CIQ;

import java.io.Serializable;

/**
 * @category 货物信息
 * @author 刘毅达
 * 
 */
public class GoodsInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String declNO;
	private String goodsName;	

	public GoodsInfo(String goodsName) {
		super();
		this.goodsName = goodsName;
	}	

	public GoodsInfo() {
		super();
	}

	public String getDeclNO() {
		return declNO;
	}

	public void setDeclNO(String declNO) {
		this.declNO = declNO;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
