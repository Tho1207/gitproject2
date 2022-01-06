package Controller;


import java.io.IOException;
import javax.servlet.*;  
import javax.servlet.http.*;  


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String userID = request.getParameter("username");
			String password = request.getParameter("password");
			 
		    String uid=getServletContext().getInitParameter("username");   
		    String pwd=getServletContext().getInitParameter("password");  
			
			if (userID != null && password.equals(pwd) && userID.equalsIgnoreCase(uid)) {
				response.sendRedirect("home.jsp");
			} else {
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<font color='red'>Username or password is invalid</font>");
				rd.include(request, response);
			}
			
			
		} catch (Exception e) {
			response.getWriter().println(e);
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
