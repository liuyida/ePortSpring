/**
 * 
 */
package com.xmhuanyu.eport.page;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.entity.PriceEntry;

/**
 * @category 价格表信息维护
 * @author EDA
 * 
 */

@ManagedBean(name = "priceListPage")
@ViewScoped
public class PriceListPage extends ListPage<PriceEntry> {
	private final Logger logger = LoggerFactory.getLogger(PriceEntry.class);
	private PriceEntry priceEntry;
	private PriceEntry selectPriceEntry;

	public PriceListPage() {		
		super();
	}

	@Override
	protected void populateList(List<PriceEntry> lazyT, int first, int pageSize) {
		// TODO  获取价格表数据
		super.populateList(lazyT, first, pageSize);
		logger.info("获取价格表数据");
		@SuppressWarnings("unchecked")
		List<PriceEntry> priceEntries = (List<PriceEntry>) FacesContext
				.getCurrentInstance().getExternalContext().getSessionMap()
				.get("priceList");
		if (priceEntries.equals(null) || priceEntries.isEmpty())
			;
		lazyT=priceEntries;
		getLazyModel().setRowCount(priceEntries.size());
	}

	public PriceEntry getPriceEntry() {
		return priceEntry;
	}

	public void setPriceEntry(PriceEntry priceEntry) {
		this.priceEntry = priceEntry;
	}

	public PriceEntry getSelectPriceEntry() {
		return selectPriceEntry;
	}

	public void setSelectPriceEntry(PriceEntry selectPriceEntry) {
		this.selectPriceEntry = selectPriceEntry;
	}

}
