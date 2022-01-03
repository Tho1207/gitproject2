package controller.product;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ListController() {
        super();
        
    }
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("text/html;charset=UTF-8");
		try {
			String index = request.getParameter("index");
			if (index==null) {
				index = "1";
			}
			int indexPage = Integer.parseInt(index);
			List<Product> ls = new ListProductDAO().getPaging(indexPage);
			request.setAttribute("products", ls);
			request.setAttribute("indexPage", indexPage);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}catch (Exception ex) {
				Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(request, response);
		
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	processRequest(request, response);
    }
}
