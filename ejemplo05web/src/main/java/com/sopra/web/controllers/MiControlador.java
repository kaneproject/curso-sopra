package com.sopra.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MiControlador
 */
@WebServlet({"/saludo","/misHuevos"})
public class MiControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/ejemplo05web/saludo?nombre=Ruben&apellido1=gomez&apellido2=garcia&select=select * from tabla where nombre = 'ruben'
		String nombre = request.getParameter("nombre");
		HttpSession session = request.getSession();
		request.setAttribute("saludo", nombre + " desde el servlet");
		getServletContext()
			.getRequestDispatcher("/WEB-INF/jsps/saludar.jsp")
			.forward(request, response);
	}

}
