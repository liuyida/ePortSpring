package com.xmhuanyu.eport.entity;

import java.io.Serializable;

/**
 * @category CIQDepart部门
 * @author EDA
 * 
 */
public class CIQDepart implements Serializable {
	private Integer seqno;
	private String ciqId;
	private String ciqName;
	private boolean isused;

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getCiqId() {
		return ciqId;
	}

	public void setCiqId(String ciqId) {
		this.ciqId = ciqId;
	}

	public String getCiqName() {
		return ciqName;
	}

	public void setCiqName(String ciqName) {
		this.ciqName = ciqName;
	}

	public boolean isIsused() {
		return isused;
	}

	public void setIsused(boolean isused) {
		this.isused = isused;
	}

}
