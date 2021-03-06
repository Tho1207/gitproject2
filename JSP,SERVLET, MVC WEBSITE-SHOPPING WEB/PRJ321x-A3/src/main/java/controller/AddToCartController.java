package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
			HttpSession session = request.getSession(true);
			String idd= request.getParameter("id");
			String action = request.getParameter("action");
			if (action != null && action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart")==null) {
					session.setAttribute("cart", new Cart());
				}
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProduct("" + id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(), p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),1));
				session.setAttribute("cart", c);
			} else if (action != null && action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(idd);
				Cart c = (Cart) session.getAttribute("cart");
				c.remove(id);
				session.setAttribute("cart", c);
			}else if (action != null && action.equalsIgnoreCase("minus")) {
				int id = Integer.parseInt(idd);
				Product p = new ListProductDAO().getProduct("" + id);
				Cart c = (Cart) session.getAttribute("cart");
				c.minus(new Product(p.getId(), p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),1));
				session.setAttribute("cart", c);
			} 
			response.sendRedirect("cart.jsp");
		} catch (Exception ex) {
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
