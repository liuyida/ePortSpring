package com.xmhuanyu.eport.page.Assist;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.xmhuanyu.eport.entity.BankRate;
import com.xmhuanyu.eport.entity.PriceEntry;

/**
 * @author EDA
 *
 */
public class MetalOrderPageAssist {
	
	public double calculateValueRMB(FacesContext context,double valueUS){
		BankRate bankRate =new BankRate();
		return valueUS*bankRate.getRate();		
	}
	
	public double calculateFee(FacesContext context,double valueRMB){
		@SuppressWarnings("unchecked")
		Map<String, PriceEntry> priceMap = (Map<String, PriceEntry>) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("priceMap");
		PriceEntry priceEntry=priceMap.get("");
		double cash=valueRMB*priceEntry.getScale();
		if(cash>priceEntry.getMaxPrice()) 
			cash=priceEntry.getMaxPrice();
		else if(cash<priceEntry.getMinPrice())
			cash=priceEntry.getMinPrice();
		return cash;
	}
}
