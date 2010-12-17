package com.xmhuanyu.eport.third.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Document document = new Document();
		response.setContentType("application/pdf");
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					response.getOutputStream());
			document.open();

			StringBuffer javascript = new StringBuffer();

			javascript.append("var params = this.getPrintParams();");

			javascript
					.append("params.interactive =	params.constants.interactionLevel.silent;");
			javascript.append("params.printerName=\"MY_PRINTER_NAME\";");
			javascript
					.append("params.pageHandling = params.constants.handling.shrink;");

			javascript.append("this.print(params);");

			PdfAction pdfAction = PdfAction.javaScript(javascript.toString(),
					writer);
			writer.addJavaScript(pdfAction);

			document.add(new Paragraph("Testing Silent Printing with iText"));

			document.add(new Paragraph("Hello World"));
			document.add(new Paragraph(new Date().toString()));
		} catch (DocumentException de) {
			de.printStackTrace();
			System.err.println("document: " + de.getMessage());
		}
		document.close();
	}

	@SuppressWarnings("unused")
	private void output(final HttpServletResponse response,
			final String filePathAndFileName, final String mimeType) throws IOException {
		File file = new File(filePathAndFileName);

		// set response headers
		response.setContentType((mimeType != null) ? mimeType
				: "application/octet-stream");
		response.setContentLength((int) file.length());

		// read and write file
		ServletOutputStream op = response.getOutputStream();
		// 128 KB buffer
		int bufferSize = 131072;
		FileInputStream fileInputStream = new FileInputStream(file);
		FileChannel fileChannel = fileInputStream.getChannel();
		// 6x128 KB = 768KB byte buffer
		ByteBuffer bb = ByteBuffer.allocateDirect(786432);
		byte[] barray = new byte[bufferSize];
		int nRead, nGet;

		try {
			while ((nRead = fileChannel.read(bb)) != -1) {
				if (nRead == 0)
					continue;
				bb.position(0);
				bb.limit(nRead);
				while (bb.hasRemaining()) {
					nGet = Math.min(bb.remaining(), bufferSize);
					// read bytes from disk
					bb.get(barray, 0, nGet);
					// write bytes to output
					op.write(barray);
				}
				bb.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bb.clear();
			fileChannel.close();
			fileInputStream.close();
		}

	}

}
