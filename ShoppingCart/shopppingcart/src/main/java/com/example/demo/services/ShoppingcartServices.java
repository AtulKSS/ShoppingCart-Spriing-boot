package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.dao.ShoppingDao;

public interface ShoppingcartServices {
	
	public List<Shoppingcart> showitems();
	
	public Shoppingcart additem(Shoppingcart shoppingcart);
	
	public Shoppingcart getsingleitem(long itemID);
	
	public Shoppingcart deleteitem(Shoppingcart shoppingcart);
	
	public void removeitem(long itemID);

	public long sumitems();
	
	public List<Shoppingcart> getinfo();

	public List<Shoppingcart> getinfo(Long price);

	public Object getUserFullName();


	
	


}
