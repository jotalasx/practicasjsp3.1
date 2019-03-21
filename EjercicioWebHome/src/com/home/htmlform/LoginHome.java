package com.home.htmlform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginHome")
public class LoginHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginHome() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// 1. Provides a way to identify a user across more than one page request or visit to a Web site and
				// to store information about that user. The servlet container uses this interface to create a session
				// between an HTTP client and an HTTP server.
				// 2. Returns the current session associated with this request, or if the request does not have a session, creates one.
				HttpSession httpsession = request.getSession();
				// Returns the object bound with the specified name in this session.
				Usuario usuario = (Usuario) httpsession.getAttribute("USUARIO");
				// 3. Defines an object that receives requests from the client and sends them to any resource
				// (such as a servlet, HTML file, or JSP file) on the server. The servlet container creates
				// the RequestDispatcher object, which is used as a wrapper around a server resource located at
				// a particular path or given by a particular name.
				// 4. Returns a RequestDispatcher object that acts as a wrapper for the resource located at the given path.
				// A RequestDispatcher object can be used to forward a request to the resource or to include the resource in a response.
				RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
				if (usuario==null) {
					String name = request.getParameter("firstname");
					String surname = request.getParameter("lastname");
					usuario = new Usuario(name, surname);
					httpsession.setAttribute("USUARIO", usuario);
				}else {
					String weight = request.getParameter("weight");
					String height = request.getParameter("height");
					String phoneNum = request.getParameter("phone");
					usuario.setWeight(weight);
					usuario.setHeight(height);
					usuario.setPhoneNum(phoneNum);
					httpsession.setAttribute("USUARIO", usuario);
				}
				// 5. Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
				dispatcher.forward(request, response);
	}

}
