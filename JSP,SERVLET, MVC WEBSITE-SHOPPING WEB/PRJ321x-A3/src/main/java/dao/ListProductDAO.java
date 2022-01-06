package dao;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import context.DBContext;
import model.Product;
public class ListProductDAO {
	public List<Product> search(String characters) throws Exception {
		List<Product> list = new ArrayList<>();
		list.clear();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from Products where product_name like ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + characters+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Product getProduct(String characters) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select * from Products where product_id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, characters);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getNumberPage() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select count(*) from Products";
		int countPage = 0;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			int total = 0;
			while (rs.next()) {
				total = rs.getInt(1);
			}
			countPage = total/6;
			if (total % 6 != 0) {
				countPage++;}
			
			} catch(Exception e) {
			e.printStackTrace();
		}
		return countPage;
	}
	
	public List<Product> getPaging(int index) {
		List<Product> list = new ArrayList<>();
		list.clear();
		String query = "SELECT *\r\n"
				+ "FROM [dbo].[Products]\r\n"
				+ "ORDER BY product_id\r\n"
				+ "OFFSET ? ROWS \r\n"
				+ "FETCH FIRST 6 ROWS ONLY ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3),
						rs.getFloat(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7)
						));
			}
			
			} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
//	public static void main(String[] args) throws Exception {
//	
//	ListProductDAO dao = new ListProductDAO();
//	List<Product> ls = dao.search("iphone");
//	for (Product a : ls) {
//		System.out.println(a);
//	
//	
//	}}
	

}
