package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletTXT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletTXT() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition","attachment;filename=archivo.txt");

		ServletOutputStream out = response.getOutputStream();
		
		out.print("lo que tu quieras ");
		out.flush();
		out.close();
	}

}