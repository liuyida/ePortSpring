/**
 * 
 */
package com.xmhuanyu.eport.third.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Huanyu
 *
 */
public class PDFPrintServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		 
		//URL url = new URL(request.getParameter("url"));		
		File pdffile=new File("d:\\PrintPdf\\23.pdf");
		InputStream is=new FileInputStream(pdffile);
		PdfReader reader = new PdfReader(is);
		try {
			PdfStamper stamper = new PdfStamper(reader,response.getOutputStream());
			PdfWriter writer = stamper.getWriter();
 
			StringBuffer javascript = new StringBuffer();
			//javascript.append("JSSilentPrint(this)");
			javascript.append("this.print({bUI: false,bSilent: false,bShrinkToFit: false,nStart:1,nEnd:1});").append("\r\nthis.closeDoc();");
 
			PdfAction pdfAction= PdfAction.javaScript(javascript.toString(), writer);
			writer.addJavaScript(pdfAction);
			stamper.close();
 
		} catch (DocumentException de) {
			de.printStackTrace();
			System.err.println("document: " + de.getMessage());
		}	
	}	

}
