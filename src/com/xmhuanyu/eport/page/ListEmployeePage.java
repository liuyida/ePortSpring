package com.xmhuanyu.eport.page;

import java.util.List;

import com.xmhuanyu.eport.entity.Employee;

/**
 * @category 员工信息显示页面
 * @author Huanyu
 * 
 */

public class ListEmployeePage extends ListPage<Employee> {

	private Employee selectEmp;
	private Employee aempInfo;

	@Override
	protected void populateList(List<Employee> lazyT, int first, int pageSize) {
		// TODO 列出Employee数据
		super.populateList(lazyT, first, pageSize);
	}

	public Employee getSelectEmp() {
		return selectEmp;
	}

	public void setSelectEmp(Employee selectEmp) {
		this.selectEmp = selectEmp;
	}

	public Employee getAempInfo() {
		return aempInfo;
	}

	public void setAempInfo(Employee aempInfo) {
		this.aempInfo = aempInfo;
	}

}
