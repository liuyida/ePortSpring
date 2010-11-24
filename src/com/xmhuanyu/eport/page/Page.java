/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

/**
 *
 * @author Huanyu
 */
public abstract class Page {

    private boolean billBtn;
    private boolean saveBtn;
    private boolean printRelBtn;
    private boolean printReportBtn;

    public boolean isBillBtn() {
        return billBtn;
    }

    public void setBillBtn(boolean billBtn) {
        this.billBtn = billBtn;
    }

    public boolean isPrintRelBtn() {
        return printRelBtn;
    }

    public void setPrintRelBtn(boolean printRelBtn) {
        this.printRelBtn = printRelBtn;
    }

    public boolean isPrintReportBtn() {
        return printReportBtn;
    }

    public void setPrintReportBtn(boolean printReportBtn) {
        this.printReportBtn = printReportBtn;
    }

    public boolean isSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(boolean saveBtn) {
        this.saveBtn = saveBtn;
    }

    public abstract String acculateFee();

    public abstract String saveOrder();
}
