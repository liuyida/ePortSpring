/**
 * 
 */
package com.xmhuanyu.eport.third.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Huanyu
 *
 */
public class JRPrintServlet extends HttpServlet {
	   public void service(
		        HttpServletRequest request,
		        HttpServletResponse response
		        ) throws IOException, ServletException{
		            
		                    String fileName ="d:\\printpdf\\23.pdf";//我的测试报表格式文件		                  
						    File file=new File(fileName);
							InputStream is=new FileInputStream(file);
							
							System.out.println("success");
		                            
		                   // java.sql.Connection conn = DBBean.getConnection(); //获取数据库连接
		                   // JasperPrint jpt = JasperFillManager.fillReport(jrt,hs,conn));//填充报表数据生成JasperPrint对象
		                    
		                    response.setContentType("application/octet-stream");
		                    ServletOutputStream ouputStream = response.getOutputStream();
		            
		                    ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		                    oos.writeObject(is);
		                    //oos.writeObject(jpt);//将JasperPrint对象写入对象输出流中
		                    oos.flush();
		                    oos.close();
		                  
		            }    
		    }

