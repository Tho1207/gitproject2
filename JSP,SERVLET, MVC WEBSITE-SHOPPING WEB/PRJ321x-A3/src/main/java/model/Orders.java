package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Orders {
	private int orderId, status;
	private float price;
	private String address, phoneNumber, userMail, discount;
	private String orderDate;
	private Date receivedDate;
	private List<ProductOrders> lp;
	
	public Orders() {}
	public Orders(String userMail, int status, String discount, String address, String phoneNumber) {
		this.userMail = userMail;
		this.status = status;
		this.discount = discount;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public Orders(int orderId, float price, int status, String orderDate, String address, String phoneNumber, List<ProductOrders>lp, String userMail, Date receivedDate ) {
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userMail = userMail;
		this.receivedDate = receivedDate;
	}


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getOrderDate() {
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		return dateFormat.format(orderDate);
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public List<ProductOrders> getLp() {
		return lp;
	}

	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}


}
