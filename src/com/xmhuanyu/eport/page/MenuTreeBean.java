package com.xmhuanyu.eport.page;

import java.io.Serializable;

import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named("menuTreeBean")
public class MenuTreeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private TreeNode root;
	private TreeNode sysRoot;// 系统管理菜单
	private TreeNode baseInfoRoot;// 基础数据管理菜单
	private TreeNode queryRoot;//查询统计查单
	private TreeNode selectNode;

	public TreeNode getSelectNode() {
		return selectNode;
	}

	public void setSelectNode(TreeNode selectNode) {
		this.selectNode = selectNode;

	}

	public MenuTreeBean() {
		makeBaseInfoRoot();
		makeSysRoot();
		makeBizRoot();
		makeQueryRoot();
	}	

	@SuppressWarnings("unused")
	private void makeQueryRoot() {
		queryRoot=new DefaultTreeNode("queryRoot",null);
		MenuNode turnoverMN=new MenuNode("营业额统计", null);
		MenuNode dailyMN=new MenuNode("日报表", null);
		MenuNode weekMN=new MenuNode("一周营业额统计表", null);
		MenuNode monthMN=new MenuNode("月统计报表分析", null);
		TreeNode turnoverTN=new DefaultTreeNode(turnoverMN, queryRoot);
		TreeNode dailyTN=new DefaultTreeNode(dailyMN, queryRoot);
		TreeNode weekTN=new DefaultTreeNode(weekMN, queryRoot);
		TreeNode monthTN=new DefaultTreeNode(monthMN, queryRoot);
		
	}

	public void makeSysRoot() {

	}

	@SuppressWarnings("unused")
	public void makeBaseInfoRoot() {
		baseInfoRoot = new DefaultTreeNode("baseInfoRoot", null);
		MenuNode rateNode = new MenuNode("汇率数据维护", "/pages/base/bankRatePage.xhtml");
		TreeNode rateTreeNode = new DefaultTreeNode(rateNode, baseInfoRoot);

	}

	@SuppressWarnings("unused")
	public void makeBizRoot() {
		root = new DefaultTreeNode("root", null);
		MenuNode indexNode=new MenuNode("前台首页", "/pages/index/cashIndex.xhtml");
		TreeNode indexTreeNode=new DefaultTreeNode(indexNode, root);
		// 货物检疫处理
		MenuNode goodNode = new MenuNode("货物检疫处理", null);
		TreeNode goodTreeNode = new DefaultTreeNode(goodNode, root);
		MenuNode woodGoodNode=new MenuNode("植物产品检疫处理", null);
		TreeNode woodGoodTreeNode=new DefaultTreeNode(woodGoodNode,goodTreeNode);
		MenuNode metalNode = new MenuNode("旧航材检疫处理",
				"/pages/metalOrderPage.xhtml");
		TreeNode metalTreeNode = new DefaultTreeNode(metalNode, goodTreeNode);
		// 外包装检疫处理
		MenuNode packNode = new MenuNode("外包装检疫处理", null);
		TreeNode packTreeNode = new DefaultTreeNode(packNode, root);
		MenuNode woodPackNode = new MenuNode("木质包装检疫处理", null);
		TreeNode woodPackTreeNode = new DefaultTreeNode(woodPackNode,
				packTreeNode);
		MenuNode woodPaceMBNode = new MenuNode("熏蒸处理", null);
		MenuNode woodPaceHTNode = new MenuNode("热处理", null);
		TreeNode woodPaceMBTreeNode = new DefaultTreeNode(woodPaceMBNode,
				woodPackTreeNode);
		TreeNode woodPaceHTTreeNode = new DefaultTreeNode(woodPaceHTNode,
				woodPackTreeNode);	
		MenuNode animalNode=new MenuNode("动物产品外包装检疫处理", null);
		TreeNode animaliTreeNode=new DefaultTreeNode(animalNode,packTreeNode);
		// 运载工具检疫处理
		MenuNode carryNode = new MenuNode("运载工具检疫处理", null);
		TreeNode carryTreeNode = new DefaultTreeNode(carryNode, root);
		MenuNode airNode = new MenuNode("航空器检疫处理", null);
		MenuNode shipNode = new MenuNode("船舶检疫处理", null);
		MenuNode conNode = new MenuNode("集装箱检疫处理", null);
		TreeNode airTreeNode = new DefaultTreeNode(airNode, carryTreeNode);
		TreeNode shipTreeNode = new DefaultTreeNode(shipNode, carryTreeNode);
		TreeNode conTreeNode = new DefaultTreeNode(conNode, carryTreeNode);		
	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSysRoot() {
		return sysRoot;
	}

	public TreeNode getBaseInfoRoot() {
		return baseInfoRoot;
	}

	public TreeNode getQueryRoot() {
		return queryRoot;
	}	

}
