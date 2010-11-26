/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.entity.OrderInfo;
import com.xmhuanyu.eport.third.DB.CIQ.DeclInfo;

/**
 * 
 * @author Huanyu
 */

public class MetalOrderPage extends Page {
	private final Logger logger = LoggerFactory.getLogger(MetalOrderPage.class);

    public MetalOrderPage() {
        super();
        DeclInfo declInfo=(DeclInfo) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("declInfo");
        orderInfo=new OrderInfo();        
        orderInfo.setBno(declInfo.getDeclNO());        
       
    }
    private OrderInfo orderInfo;

    public OrderInfo getOrderInfo() {
    	if(orderInfo==null) orderInfo=new OrderInfo();
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
    
    public void calculateFee(ActionEvent ae){
    	logger.info("计算旧航材检疫处理费用");
    	if(orderInfo.getValueRMB()==0.00)
    		orderInfo.setValueRMB(orderInfo.getValueUS()*2);
    	orderInfo.setCash(orderInfo.getValueUS()*0.2);
    }
    
}