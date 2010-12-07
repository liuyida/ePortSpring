package com.xmhuanyu.eport.page;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.entity.CIQDepart;

/**
 * @category CIQDepart页面信息维护
 * @author EDA
 * 
 */
@ManagedBean(name = "ciqDepartPage")
@ViewScoped
public class CIQDepartPage extends ListPage<CIQDepart> {
	private final Logger logger = LoggerFactory.getLogger(CIQDepart.class);
	private CIQDepart ciqDepart;
	private CIQDepart selectCiqDepart;

	public CIQDepartPage() {
		// TODO 获取CIQDepart数据条目数
		super();
	}

	@Override
	protected void populateList(List<CIQDepart> lazyT, int first, int pageSize) {
		// TODO 从Application Session中 获取CIQ数据填充
		logger.info("从Application Session中 获取CIQ数据填充");
		super.populateList(lazyT, first, pageSize);
	}

	public void addDepartListener(ActionEvent ae) {

	}

	public void changeDepartListener(ActionEvent ae) {

	}

	public CIQDepart getCiqDepart() {
		if (ciqDepart == null)
			ciqDepart = new CIQDepart();
		return ciqDepart;
	}

	public void setCiqDepart(CIQDepart ciqDepart) {
		this.ciqDepart = ciqDepart;
	}

	public CIQDepart getSelectCiqDepart() {
		return selectCiqDepart;
	}

	public void setSelectCiqDepart(CIQDepart selectCiqDepart) {
		this.selectCiqDepart = selectCiqDepart;
	}

}
