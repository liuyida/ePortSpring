package com.xmhuanyu.eport.page.Assist;

import com.xmhuanyu.eport.third.DB.CIQ.CIQDAO;
import com.xmhuanyu.eport.third.DB.CIQ.DeclInfo;

/**
 * @category author Huanyu
 * 
 */
public class IndexPageAssist {
	
	public DeclInfo getDeclInfoByDeclNO(String declNO) {
		DeclInfo declInfo = null;
		CIQDAO ciqdao = new CIQDAO();	
		if (ciqdao.isConn())
			declInfo = ciqdao.getDeclInfo(declNO);
		else {			
			declInfo = new DeclInfo();
			declInfo.setDeclNO(declNO);
		}

		return declInfo;
	}
	
}