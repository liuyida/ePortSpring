package com.xmhuanyu.eport.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @category 业务基本信息息
 * @author Huanyu  
 * @
 */
public class OrderInfo {

    private String bno;
    private String declNo;
    private Date acceptDate;//受理日期
    private Date acceptTime;//受理时间
    private String consignor;//货主
    private String declUnit;//报检单位
    private String goodsName;//货物名称
    private BigDecimal valueRMB;//货值人民币
    private BigDecimal valueUS;//货值美元
    private BigDecimal exchangeRate;//汇率
    private String tradeRegions;//贸易地区
    private String stopsPort;//经停口岸
    private String placeName;//货物停放地点
    private String declAttr;//报检属性 T-法检，F-非法检，C-现场查验，W-客户委托，O-其他

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getConsignor() {
        return consignor;
    }

    public void setConsignor(String consignor) {
        this.consignor = consignor;
    }

    public String getDeclNo() {
        return declNo;
    }

    public void setDeclNo(String declNo) {
        this.declNo = declNo;
    }

    public String getDeclUnit() {
        return declUnit;
    }

    public void setDeclUnit(String declUnit) {
        this.declUnit = declUnit;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getValueRMB() {
        return valueRMB;
    }

    public void setValueRMB(BigDecimal valueRMB) {
        this.valueRMB = valueRMB;
    }

    public BigDecimal getValueUS() {
        return valueUS;
    }

    public void setValueUS(BigDecimal valueUS) {
        this.valueUS = valueUS;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStopsPort() {
        return stopsPort;
    }

    public void setStopsPort(String stopsPort) {
        this.stopsPort = stopsPort;
    }

    public String getTradeRegions() {
        return tradeRegions;
    }

    public void setTradeRegions(String tradeRegions) {
        this.tradeRegions = tradeRegions;
    }

    public String getDeclAttr() {
        return declAttr;
    }

    public void setDeclAttr(String declAttr) {
        this.declAttr = declAttr;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    
    
}