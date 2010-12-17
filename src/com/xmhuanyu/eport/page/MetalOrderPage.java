/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import java.io.Serializable;

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
public class MetalOrderPage extends Page implements Serializable{
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
		{
			orderInfo.setDeclNo(declInfo.getDeclNO());
			orderInfo.setConsignor(declInfo.getConsignorName());
			orderInfo.setGoodsName(declInfo.getGoodsName());
			orderInfo.setPlaceName(declInfo.getGoodPlace());
			orderInfo.setTradeRegions(declInfo.getEntName());
			
		}

	}

	public OrderInfo getOrderInfo() {
		if (orderInfo == null)
			orderInfo = new OrderInfo();
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public void calculateFee(ActionEvent ae) {
		logger.info("计算旧航材检疫处理费用");
		orderInfo.setValueRMB(metalPageAssist.calculateValueRMB(context,
				orderInfo.getValueUS()));
		orderInfo.setCash(metalPageAssist.calculateFee(context,
				orderInfo.getValueRMB()));

	}

	public void saveOrder(ActionEvent ae) {
		logger.info("业务保存");
	}

}