package com.xmhuanyu.eport.third.DB.CIQ;

import java.io.Serializable;
import java.util.Date;

/**
 * @category 报检信息
 * @author 刘毅达
 * 
 */
public class DeclInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String declNO;
	private Date declDate;
	private String entName;
	private String consignorName;
	private String consigneeName;
	private String carrierNO;
	private String transportTools;
	private String goodPlace;
	private int cnt20;
	private int cnt40;
	private String goodsName;
	private String cnt20Str;
	private String cnt40Str;

	public String getCarrierNO() {
		return carrierNO;
	}

	public void setCarrierNO(String carrierNO) {
		this.carrierNO = carrierNO;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public Date getDeclDate() {
		return declDate;
	}

	public void setDeclDate(Date declDate) {
		this.declDate = declDate;
	}

	public String getDeclNO() {
		return declNO;
	}

	public void setDeclNO(String declNO) {
		this.declNO = declNO;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getGoodPlace() {
		return goodPlace;
	}

	public void setGoodPlace(String goodPlace) {
		this.goodPlace = goodPlace;
	}

	public String getTransportTools() {
		return transportTools;
	}

	public void setTransportTools(String transportTools) {
		this.transportTools = transportTools;
	}

	public int getCnt20() {
		return cnt20;
	}

	public void setCnt20(int cnt20) {
		this.cnt20 = cnt20;
	}

	public String getCnt20Str() {
		return cnt20Str;
	}

	public void setCnt20Str(String cnt20Str) {
		this.cnt20Str = cnt20Str;
	}

	public int getCnt40() {
		return cnt40;
	}

	public void setCnt40(int cnt40) {
		this.cnt40 = cnt40;
	}

	public String getCnt40Str() {
		return cnt40Str;
	}

	public void setCnt40Str(String cnt40Str) {
		this.cnt40Str = cnt40Str;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
