package com.xmhuanyu.eport.third.Util;

import java.applet.Applet;
import java.net.URL;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class JRPrinterApplet extends Applet {
    private URL url = null;
    
    public void init(){
        String strUrl = getParameter("REPORT_URL");
        if(strUrl!=null){
            try{
                System.out.println(getCodeBase());
                url = new URL(getCodeBase(),strUrl);//从获得html参数中获得报表URL
                System.out.println(url);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else
            JOptionPane.showMessageDialog(this, "Source URL not specified");
            
        
    }
    
    public void start(){
        if(url!=null){
            try{
                JOptionPane.showMessageDialog(this, url);
                Object obj = JRLoader.loadObject(url);//发送对象请求，获得JasperPrint对象
                System.out.println(obj);
                JasperPrintManager.printReport((JasperPrint)obj, true);//调用方法打印所获得的JasperPrint对象
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}