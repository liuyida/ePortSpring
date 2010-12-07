/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.xmhuanyu.eport.third.DB.CIQ.DeclInfo;

/**
 * @category 业务受理页面
 * @author Huanyu
 */
@Named("indexPage")
@RequestScoped
public class IndexPage extends Page {

	private String declNO;

	public String getDeclNO() {
		return declNO;
	}

	public void setDeclNO(String declNO) {
		this.declNO = declNO;
	}

	public String switchToMetalOrder() {
		//IndexPageServices services=new IndexPageServices();
		//DeclInfo declInfo= services.getDeclInfoByDeclNO(declNO);
		DeclInfo declInfo=new DeclInfo();
		declInfo.setDeclNO("12345");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("declInfo", declInfo); 
		return "/pages/metalOrderPage.xhtml";
	}

	@Override
	public String acculateFee() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String saveOrder() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
