package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import context.DBContext;
import model.Account;
import model.Cart;
import model.Orders;
import model.Product;
import model.ProductOrders;

public class OrdersDAO {
	
	public void insertOrder(Orders o) throws Exception {
		String query= "insert into [dbo].[Orders] (user_mail,order_status,order_date,order_discount_code,order_address)\r\n"
				+ "values (?,?,?,?,?);";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, o.getUserMail());
			ps.setInt(2, o.getStatus());
			Date date = new Date();
			SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
			String stringDate = DateFor.format(date);
			ps.setString(3, stringDate);
			ps.setString(4, o.getDiscount());
			ps.setString(5, o.getAddress());
			ps.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public Orders checkExistdetail(int orderID) {
		String query = "select * from [dbo].[Orders_detail] where order_id = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Orders();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertOrderDetail(Product p, int intId) throws Exception {
		String query = "insert into [dbo].[Orders_detail] (order_id, product_id, amount_product, price_product) \r\n"
				+ "values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try { 
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, intId);
			ps.setInt(2, p.getId());
			ps.setInt(3, p.getNumber());
			int totalPrice = (int) (Math.round(p.getNumber()*p.getPrice()));
			ps.setInt(4, totalPrice );
			ps.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public void register(String address, String phone, String user) {
		String query= "update Account set user_address=?, user_phone=? where user_mail = user";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, address);
			ps.setString(2, phone);
			ps.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
		
	

}
 