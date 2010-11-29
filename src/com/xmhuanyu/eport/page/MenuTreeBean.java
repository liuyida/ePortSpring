package com.xmhuanyu.eport.page;

import java.io.Serializable;

import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

public class MenuTreeBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeNode root;

	@SuppressWarnings("unused")
	public MenuTreeBean() {
		
		root = new DefaultTreeNode("root", null);
		MenuNode  nd1=new MenuNode("航空器检疫处理",null);
		MenuNode  nd2=new MenuNode("船舶检疫处理",null);
		MenuNode  nd3=new MenuNode("植物类检疫处理",null);
		TreeNode node0 = new DefaultTreeNode(nd1, root);
		TreeNode node1 = new DefaultTreeNode(nd2, root);
		TreeNode node2 = new DefaultTreeNode(nd3, root);
		MenuNode  n1=new MenuNode("旧航材检疫处理业务","../pages/metalOrderPage.xhtml");
		MenuNode  n2=new MenuNode("n2","/faces/pages/metalOrderPage.xhtml");
		TreeNode node00 = new DefaultTreeNode(n1, node0);
		TreeNode node01 = new DefaultTreeNode(n2, node0);
		MenuNode  n10=new MenuNode("n10","/faces/pages/metalOrderPage.xhtml");
		MenuNode  n11=new MenuNode("n11","/faces/pages/metalOrderPage.xhtml");
		TreeNode node10 = new DefaultTreeNode(n10, node1);
		TreeNode node11 = new DefaultTreeNode(n11, node1);
		MenuNode  n000=new MenuNode("n000","/faces/pages/metalOrderPage.xhtml");
		MenuNode  n001=new MenuNode("n001","/faces/pages/metalOrderPage.xhtml");
		MenuNode  n010=new MenuNode("n010","/faces/pages/metalOrderPage.xhtml");
		MenuNode  n100=new MenuNode("n100","/faces/pages/metalOrderPage.xhtml");
		TreeNode node000 = new DefaultTreeNode(n000, node00);
		TreeNode node001 = new DefaultTreeNode(n001, node00);
		TreeNode node010 = new DefaultTreeNode(n010, node01);
		
		TreeNode node100 = new DefaultTreeNode(n100, node10);
	}

	public TreeNode getRoot() {
		return root;
	}
}
					