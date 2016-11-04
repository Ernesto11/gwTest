package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ServletPDF extends HttpServlet {
 private static final long serialVersionUID = 1L;

 public ServletPDF() {
  super();
 }

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
  //get the output stream for writing binary data in the response.
  ServletOutputStream os = response.getOutputStream();
  //set the response content type to PDF
  response.setContentType("application/pdf"); 
  response.setHeader("Content-Disposition","attachment;filename=archivo.pdf");
  //create a new document
  Document doc = new Document();

  //create some special styles and font sizes
  Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0)); 

  try{
   
   //create an instance of the PdfWriter using the output stream
   PdfWriter.getInstance(doc, os); 

   //document header properties
   doc.addAuthor("Jhonson");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("Jhonson");
   doc.addTitle("DemoPDF");
   doc.setPageSize(PageSize.LETTER);
   doc.open();

   //add a new paragraph
   doc.add( new Paragraph("Aquí va el texto...", bfBold18));
   doc.close(); 

  }catch(DocumentException e){
   e.printStackTrace();
  }
  catch(Exception e){
   e.printStackTrace();
  }

 }

}