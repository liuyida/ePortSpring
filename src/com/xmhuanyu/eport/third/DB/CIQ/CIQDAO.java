package com.xmhuanyu.eport.third.DB.CIQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmhuanyu.eport.third.Util.PropertieUtil;



/**
 * @category CIQ数据库采集
 * @author 刘毅达
 * 
 */
public class CIQDAO {
	private boolean isConn=false;
	private Connection conn;
	private final Logger logger = LoggerFactory.getLogger(CIQDAO.class);

	public  CIQDAO() {
		Properties prop = PropertieUtil.getPropertie("oracle.properties");
		try {
			Class.forName(prop.getProperty("oracle.driver"));
			DriverManager.setLoginTimeout(1);
			conn = DriverManager.getConnection(prop.getProperty("oracle.url"), prop
					.getProperty("oracle.user"), prop.getProperty("oracle.pwd"));
			logger.info(String.valueOf(isConn));
			isConn=true;
		} catch (ClassNotFoundException e) {
			logger.error("DriverClass 设置失败！");
			isConn=false;
			e.printStackTrace();
		} catch (SQLException e) {
			isConn=false;
			logger.error("数据库连接建立失败!");
			e.printStackTrace();
		}
	}

	/**
	 * @category 获取报检信息
	 * @param declno
	 * @return
	 */
	public DeclInfo getDeclInfo(String declno) {
		String declSQL = "select decl_no,decl_date,ent_name,consignor_name,consignee_name,carrier_no,transport_tools,goods_place from decl_info where decl_no=?";
		DeclInfo declInfo = new DeclInfo();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(declSQL);
			pstmt.setString(1, declno);
			rs = pstmt.executeQuery();                                           
			while (rs.next()) {
				declInfo.setDeclNO(rs.getString("decl_no"));
				declInfo.setDeclDate(rs.getDate("decl_date"));
				declInfo.setEntName(rs.getString("ent_name"));
				declInfo.setConsignorName(rs.getString("consignor_name"));
				declInfo.setConsigneeName(rs.getString("consignee_name"));
				declInfo.setCarrierNO(rs.getString("carrier_no"));
				declInfo.setTransportTools(rs.getString("transport_tools"));
				declInfo.setGoodPlace(rs.getString("goods_place"));                                                              
			}
		} catch (SQLException e) {
			logger.error("报检信息采集失败！");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("断开数据库连接失败！");
				e.printStackTrace();
			}
		}
		return declInfo;
	}

	/**
	 * @category 获取集装箱信息
	 * @param declno
	 * @return
	 */
	public Map<String,ContainerInfo> getContainerInfos(String declno) {
		String conSQL = "select DECL_NO,MODEL,QTY,CODE from decl_container where decl_no=?";
		Map<String,ContainerInfo> infos = new HashMap<String,ContainerInfo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		infos.put("20", new ContainerInfo(0, ""));
		infos.put("40", new ContainerInfo(0, ""));
		try {
			pstmt = conn.prepareStatement(conSQL);
			pstmt.setString(1, declno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ContainerInfo info = new ContainerInfo();
				info.setDeclNO(rs.getString("DECL_NO"));
				info.setModel(rs.getString("MODEL"));
				info.setQty(rs.getInt("QTY")==0 ? 0 : rs.getInt("QTY"));
				info.setConDode(rs.getString("CODE")==null ? "" : rs.getString("CODE"));
				if(info.getModel().contains("20"))
					infos.put("20", info);
				else infos.put("40", info);
			}
		} catch (SQLException e) {
			logger.error("报检信息采集失败！");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("断开数据库连接失败！");
				e.printStackTrace();
			}
		}
		return infos;
	}

	/**
	 * @category 获取货物信息
	 * @param declno
	 * @return
	 */
	public List<GoodsInfo> getGoodsInfos(String declno) {
		String goodsSQL = "select decl_no,goods_name from goods_info where decl_no=?";
		List<GoodsInfo> infos = new ArrayList<GoodsInfo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(goodsSQL);
			pstmt.setString(1, declno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsInfo goodsInfo = new GoodsInfo();
				goodsInfo.setDeclNO(rs.getString("decl_no"));
				goodsInfo.setGoodsName(rs.getString("goods_name"));
				infos.add(goodsInfo);
			}

		} catch (SQLException e) {
			logger.error("报检信息采集失败！");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				logger.error("断开数据库连接失败！");
				e.printStackTrace();
			}
		}
		if(infos.isEmpty())
			infos.add(new GoodsInfo(""));
		return infos;
	}

	public boolean isConn() {
		return isConn;
	}

	public void setConn(boolean isConn) {
		this.isConn = isConn;
	}
	
}
