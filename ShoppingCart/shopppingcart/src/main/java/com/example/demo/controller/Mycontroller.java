package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.dao.ShoppingDao;
import com.example.demo.services.ShoppingcartServices;

@RestController
public class Mycontroller {
	
	@Autowired
	private ShoppingcartServices shoppingservices;
	
	@GetMapping("/showitems")
	public List<Shoppingcart> showitems()
	{
		return this.shoppingservices.showitems();
	
	}
	
	@PostMapping("/additemss")
	public Shoppingcart additem(@RequestBody Shoppingcart shoppingcart) {
		return this.shoppingservices.additem(shoppingcart);
		
	}
	
	//Getting a single item from shopping cart
	@GetMapping("/additemss/{itemID}")
	public Shoppingcart getsingleitem(@PathVariable String itemID) {
		return this.shoppingservices.getsingleitem(Long.parseLong(itemID));
	}
	
	@DeleteMapping("/additemss/{itemID}")
	public ResponseEntity<HttpStatus> removeitem(@PathVariable String itemID) {
		try {
		this.shoppingservices.removeitem(Long.parseLong(itemID));
		return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/totalitems")
	@Query("Select * from shoppingcart")
	public long sumitems() {
		return (long) this.shoppingservices.sumitems();
	}
	

	
//	@GetMapping("/total")
//	public List<Shoppingcart> getinfo();{
//		 shoppingservices.getinfo();
//	}
	
	@GetMapping("/total")
	public List<Shoppingcart> getinfo(Long price) {
	return this.shoppingservices.getinfo(price);
}
	
//	@GetMapping("/total")
//	public List<Shoppingcart> findEmp_name(String price) {
//	return this.shoppingservices.findEmp_name(price);
//}


	
	
}
