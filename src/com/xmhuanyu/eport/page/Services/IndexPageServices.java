package com.xmhuanyu.eport.page.Services;

import com.xmhuanyu.eport.third.DB.CIQ.CIQDAO;
import com.xmhuanyu.eport.third.DB.CIQ.DeclInfo;

/**
 * @category author Huanyu
 * 
 */
public class IndexPageServices {
	
	public DeclInfo getDeclInfoByDeclNO(String declNO) {
		CIQDAO ciqdao = new CIQDAO();
		DeclInfo declInfo = ciqdao.getDeclInfo(declNO);
		return declInfo;
	}
	
}