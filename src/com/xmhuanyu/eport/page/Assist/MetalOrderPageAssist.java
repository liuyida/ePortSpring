package com.xmhuanyu.eport.page.Assist;

import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.xmhuanyu.eport.entity.BankRate;
import com.xmhuanyu.eport.entity.PriceEntry;
import com.xmhuanyu.eport.services.BankRateServices;

/**
 * @author EDA
 *
 */
public class MetalOrderPageAssist {
	@Inject
	private BankRateServices rateServices;
	
	public double calculateValueRMB(FacesContext context,double valueUS){
		Date date=new Date();
		BankRate bankRate =rateServices.getBankRateByDate(date);		
		return valueUS*bankRate.getRate();		
	}
	
	public double calculateFee(FacesContext context,double valueRMB){
		@SuppressWarnings("unchecked")
		Map<String, PriceEntry> priceMap = (Map<String, PriceEntry>) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("priceMap");
		PriceEntry priceEntry=priceMap.get("0100001");
		double cash=valueRMB*priceEntry.getScale();
		if(cash>priceEntry.getMaxPrice()) 
			cash=priceEntry.getMaxPrice();
		else if(cash<priceEntry.getMinPrice())
			cash=priceEntry.getMinPrice();
		return cash;
	}
}
