package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.ListProductDAO;




public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchController2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String text = request.getParameter("s");
			request.setAttribute("inputVal", text);
			request.setAttribute("results", new ListProductDAO().search(text));
			RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
