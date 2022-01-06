package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.adminLoginDAO;
import model.Account;



public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			request.getSession(true).invalidate();
			String regexMail= "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			adminLoginDAO dao = new adminLoginDAO();
			Account acc = dao.login(user,password);
			HttpSession session = request.getSession(true);
			if (!password.matches(regex) || !user.matches(regexMail)) {
				session.setAttribute("error","invalid syntax");
				response.sendRedirect("login.jsp");
			} else {
			if( acc != null ) {
				session.setAttribute("user", user);
				Cookie ck = new Cookie("user", user);
				response.addCookie(ck);
				int role = dao.checkExist(user).getRole(); 
				if (role == 1) {
				response.sendRedirect("admin/index.jsp");
				} else {
					response.sendRedirect("paging");
				}
			}
			else {
				session.setAttribute("error", "wrong username or password");
				response.sendRedirect("login.jsp");
			}
			}
			
		} catch(NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			response.getWriter().println(ex);
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
