package com.xmhuanyu.eport.third.Util;

import java.io.File;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;

public class FinalTestPdf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FinalTestPdf ps = new FinalTestPdf();
		ps.print();

	}
	public void print() {
        //DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
        // DocFlavor flavor = new DocFlavor();
         //String strfla=flavor.getMimeType();
        //DocFlavor.URL.PDF
        //System.out.println("kuldeep check for the strfla===>>>"+strfla);
        //PrintService pservices = PrintServiceLookup.lookupDefaultPrintService();

        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);
        aset.add(new Copies(1));               
        
        /* locate a print service that can handle it */
        
        PrintService pservices = PrintServiceLookup.lookupDefaultPrintService();
//      DocFlavor d=pservices.getSupportedDocFlavors(); 
        //System.out.println("kuldeep check for ====>>>"+d.getMimeType());
        System.out.println("selected printer " + pservices.getName());
        

        /* create a print job for the chosen service */
        DocPrintJob pj = pservices.createPrintJob();
        try {
                //InputStream fis = new BufferedInputStream(new FileInputStream("D:\\PrintPdf\\kullu249.pdf"));
                File pdfFile = new File("D:\\PrintPdf\\111.pdf");

                //Doc doc = new SimpleDoc(fis, flavor, null);
                //pj.print(doc, aset);
                SimpleDoc  simpleDoc = new SimpleDoc(pdfFile, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
                System.out.println("before printing ====>>>");
                pj.print(simpleDoc, null);
                System.out.println("after printing ====>>>");

        } 
        catch (Exception e)
        {
                System.err.println(e.getMessage());
        }
	}

}
