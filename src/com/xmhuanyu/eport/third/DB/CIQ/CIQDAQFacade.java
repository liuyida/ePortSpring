package com.xmhuanyu.eport.third.DB.CIQ;

/**
 * @category CIQ数据采集抽象工厂
 * @author 刘毅达
 *
 */
public  class CIQDAQFacade {
	
	public static CIQDAQ creteCIQDAO(){
		return new CIQDAQ();
	}

}
