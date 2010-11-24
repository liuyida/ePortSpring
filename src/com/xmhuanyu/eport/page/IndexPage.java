/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xmhuanyu.eport.page;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Huanyu
 */
@ManagedBean(name = "indexPage")
public class IndexPage extends Page {

    private String declNO;

    public String getDeclNO() {
        return declNO;
    }

    public void setDeclNO(String declNO) {
        this.declNO = declNO;
    }

    public String switchToMetalOrder() {
        System.out.print("metalOrder");
        return "metalOrder";
    }

    @Override
    public String acculateFee() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String saveOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
