package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.adminLoginDAO;
import model.Account;

/**
 * Servlet implementation class RegisterControl
 */
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		if (!pass.equals(repass)) {
			response.sendRedirect("register.jsp");
		} else {
			adminLoginDAO dao = new adminLoginDAO();
			Account a = dao.checkExist(user);
			if (a==null) {
				dao.register(user,pass,name);
				response.sendRedirect("paging");
				
			} else {
				response.sendRedirect("register.jsp");
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
