/**
 * 
 */
package com.xmhuanyu.eport.entity;

import java.io.Serializable;

/**
 * @category 货物停放点
 * @author EDA
 * 
 */
public class ParkingBay implements Serializable{	
	private Integer seqno;
	private String bayId;
	private String bayName;
	private boolean mbbay;
	private boolean htbay;
	private boolean wsclbay;
	private boolean xargbay;
	private boolean xdbay;

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getBayId() {
		return bayId;
	}

	public void setBayId(String bayId) {
		this.bayId = bayId;
	}

	public String getBayName() {
		return bayName;
	}

	public void setBayName(String bayName) {
		this.bayName = bayName;
	}

	public boolean isMbbay() {
		return mbbay;
	}

	public void setMbbay(boolean mbbay) {
		this.mbbay = mbbay;
	}

	public boolean isHtbay() {
		return htbay;
	}

	public void setHtbay(boolean htbay) {
		this.htbay = htbay;
	}

	public boolean isWsclbay() {
		return wsclbay;
	}

	public void setWsclbay(boolean wsclbay) {
		this.wsclbay = wsclbay;
	}

	public boolean isXargbay() {
		return xargbay;
	}

	public void setXargbay(boolean xargbay) {
		this.xargbay = xargbay;
	}

	public boolean isXdbay() {
		return xdbay;
	}

	public void setXdbay(boolean xdbay) {
		this.xdbay = xdbay;
	}

}
