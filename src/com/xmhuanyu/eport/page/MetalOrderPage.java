/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import com.xmhuanyu.eport.entity.OrderInfo;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Huanyu
 */
@ManagedBean(name="metalOrderPage")
public class MetalOrderPage extends Page {

    public MetalOrderPage() {
        super();
        orderInfo=new OrderInfo();
        orderInfo.setBno("190932");        
       
    }
    private OrderInfo orderInfo;

    public OrderInfo getOrderInfo() {
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
    
}