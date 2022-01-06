package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.OrdersDAO;
import model.Cart;
import model.Orders;

public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("cart") == null) {
			}
			OrdersDAO dao = new OrdersDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String username = request.getParameter("name");
			String discount = request.getParameter("discount");
			String address = request.getParameter("address");
			Orders d = new Orders(username, 2, discount, address, "", null);
			dao.insertOrder(d, c);
			response.sendRedirect("index.jsp");
		} catch (Exception ex) {
			response.getWriter().println(ex);
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
