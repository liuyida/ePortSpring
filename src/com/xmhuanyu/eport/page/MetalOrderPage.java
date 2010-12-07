/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.xmhuanyu.eport.entity.OrderInfo;
import com.xmhuanyu.eport.page.Assist.MetalOrderPageAssist;
import com.xmhuanyu.eport.third.DB.CIQ.DeclInfo;

/**
 * @category 旧航材业务受理页面
 * @author Huanyu
 */
@Named("metalOrderPage")
@Scope("view")
public class MetalOrderPage extends Page {
	private final Logger logger = LoggerFactory.getLogger(MetalOrderPage.class);
	private OrderInfo orderInfo;
	private MetalOrderPageAssist metalPageAssist;
	private FacesContext context;

	public MetalOrderPage() {
		super();
		metalPageAssist = new MetalOrderPageAssist();
		context = FacesContext.getCurrentInstance();
		DeclInfo declInfo = (DeclInfo) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("declInfo");
		orderInfo = new OrderInfo();
		if (declInfo != null)
			orderInfo.setBno(declInfo.getDeclNO());

	}

	public OrderInfo getOrderInfo() {
		if (orderInfo == null)
			orderInfo = new OrderInfo();
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	@Override
	public String acculateFee() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public String saveOrder() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void calculateFee(ActionEvent ae) {
		logger.info("计算旧航材检疫处理费用");
		orderInfo.setValueRMB(metalPageAssist.calculateValueRMB(context,
				orderInfo.getValueUS()));
		orderInfo.setCash(metalPageAssist.calculateFee(context,
				orderInfo.getValueRMB()));

	}

	public void saveOrder(ActionEvent ae) {
		logger.info("");
	}

}