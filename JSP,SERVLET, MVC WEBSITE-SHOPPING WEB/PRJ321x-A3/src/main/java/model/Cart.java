package model;
import java.util.*;
public class Cart {
	private List<Product> items;
	
	public Cart() {
		items = new ArrayList<>();
		
	}
	
	public void add(Product ci) {
		for(Product x:items) {
			if (ci.getId() == x.getId()) {
				x.setNumber(x.getNumber()+1);
				return;
			}
		}
		items.add(ci);
	}

	public void minus(Product ci) {
		for (Product x : items) {
			if (ci.getId() == x.getId()) {
				x.setNumber(x.getNumber()-1);
				if (x.getNumber()==0) {
					remove(x.getId());
				}
				return;
			}
		}
	}
	
	public void remove(int id) {
		for(Product x:items) {
			if (x.getId() == id ) {
				items.remove(x);
				return;
			}
		}
	}
	
	
	
	public List<Product> getItems() {
		return items;
	}

}
