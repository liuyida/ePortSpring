/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.xmhuanyu.eport.page.Assist.IndexPageAssist;
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

		DeclInfo declInfo = new DeclInfo();
		//declInfo.setDeclNO("12345");
		IndexPageAssist indexPageAssist = new IndexPageAssist();		
		declInfo = indexPageAssist.getDeclInfoByDeclNO(declNO);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("declInfo", declInfo);
		return "/pages/metalOrderPage.xhtml";
	}

}
