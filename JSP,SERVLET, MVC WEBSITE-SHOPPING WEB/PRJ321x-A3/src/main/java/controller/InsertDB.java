package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import dao.adminLoginDAO;
import model.Account;
import model.Cart;
import model.Orders;
import model.Product;

/**
 * Servlet implementation class InsertDB
 */
public class InsertDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
			HttpSession session = request.getSession();
			String user = (String) session.getAttribute("user");
			Cart c = (Cart) session.getAttribute("cart");
			adminLoginDAO dao = new adminLoginDAO();
			Account a = dao.checkExist(user);
			OrdersDAO d = new OrdersDAO();
			Orders orders = new Orders(a.getUsr(), 1, null, a.getAddress(), a.getPhone());
			int orderid=1;
			d.insertOrder(orders);
			while(d.checkExistdetail(orderid) !=null) {
				orderid++;
			}
			for (Product p : c.getItems()) {
				d.insertOrderDetail(p, orderid);
			}
			response.sendRedirect("paging");
			
			
		}catch(Exception e) {
			e.printStackTrace();
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
 