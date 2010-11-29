package com.xmhuanyu.eport.page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.entity.BankRate;

public class BankRatePage {
	private final Logger logger = LoggerFactory.getLogger(BankRatePage.class);
	private LazyDataModel<BankRate> lazyModel;
	private BankRate selectBankRate;

	@SuppressWarnings("serial")
	public BankRatePage() {
		lazyModel = new LazyDataModel<BankRate>() {						

			@Override
			public List<BankRate> load(int first, int pageSize,
					String sortField, boolean sortOrder,
					Map<String, String> filters) {
				logger.info("加载汇率数据{}-{}", new Object[] { first,
						(first + pageSize) });
				List<BankRate> lazyBankRates = new ArrayList<BankRate>();
				populateBankRate(lazyBankRates, first, pageSize);
				return lazyBankRates;
			}
		};
		// 设置最大数据记录
		lazyModel.setRowCount(1000);
	}

	/**
	 * @category 查询分页数据
	 * @param lazyBankRates
	 * @param pageSize
	 */
	protected void populateBankRate(List<BankRate> lazyBankRates, int first,
			int pageSize) {
		// TODO 从数据库中加载汇率数据，按日期排列
		for (int i = 0 + first; i < pageSize+first; i++)
			lazyBankRates.add(new BankRate(new Date(), i));

	}

	public LazyDataModel<BankRate> getLazyModel() {
		return lazyModel;
	}

	public BankRate getSelectBankRate() {
		return selectBankRate;
	}

	public void setSelectBankRate(BankRate selectBankRate) {
		this.selectBankRate = selectBankRate;
	}

}
