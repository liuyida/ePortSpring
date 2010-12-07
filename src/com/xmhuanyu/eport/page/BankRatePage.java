package com.xmhuanyu.eport.page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.entity.BankRate;

/**
 * @category 获取银行汇率数据
 * @author Huanyu
 * 
 */
@Named("bankRatePage")
@ViewScoped
public class BankRatePage extends ListPage<BankRate>{
	private final Logger logger = LoggerFactory.getLogger(BankRatePage.class);
	private BankRate bankRate;
	private BankRate selectBankRate;
	
	public BankRatePage() {		
		getLazyModel().setRowCount(100000000);  
	}

	protected void populateList(List<BankRate> lazyT, int first, int pageSize) {
		logger.info("加载{}数据{}--{}", new Object[] { this.getClass(), first,
				pageSize });
		// TODO 从数据库中加载汇率数据，按日期排列
		for (int i = 0 + first; i < pageSize + first; i++)
			lazyT.add(new BankRate(new Date(), i));
	}

	public BankRate getBankRate() {
		if(bankRate==null) bankRate=new BankRate();
		return bankRate;
	}

	public void setBankRate(BankRate bankRate) {
		this.bankRate = bankRate;
	}

	public void addRate(ActionEvent ae) {
		// TODO 添加汇率数据
		logger.info("添加汇率数据！");
		List<BankRate> lazyBankRates = new ArrayList<BankRate>();
		populateList(lazyBankRates, 20, 30);
		getLazyModel().setWrappedData(lazyBankRates);
	}

	public void changeRate(ActionEvent ae) {
		// TODO 修改汇率数据
		logger.info("修改汇率数据！");
	}

	public BankRate getSelectBankRate() {
		return selectBankRate;
	}

	public void setSelectBankRate(BankRate selectBankRate) {
		this.selectBankRate = selectBankRate;
	}

}
