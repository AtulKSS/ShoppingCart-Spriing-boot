package com.example.demo.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.Entitity.Shoppingcart;
import com.example.demo.dao.ShoppingDao;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Service
public class Shoppingcartimplementation implements ShoppingcartServices {
	@Autowired
	private ShoppingDao shoppingdao;
	public Shoppingcartimplementation () {
	
	}
	
	@Override
	public List<Shoppingcart> showitems() {		
		return shoppingdao.findAll();
	}

	@Override
	public Shoppingcart additem(Shoppingcart shoppingcart) {
		// TODO Auto-generated method stub
		shoppingdao.save(shoppingcart);
		return shoppingcart;
	}

//	@SuppressWarnings("deprecation")
	@Override
	public Shoppingcart getsingleitem(long itemID) {
		return shoppingdao.getReferenceById(itemID);
		
	}

	@Override
	public Shoppingcart deleteitem(Shoppingcart shoppingcart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeitem(long parseLong) {
		// TODO Auto-generated method stub
		Shoppingcart entity = shoppingdao.getReferenceById(parseLong);
		shoppingdao.delete(entity);
	}

	@Override
	@Query(value = "SELECT SUM(shoppingcart) FROM price", nativeQuery = true)
	public long sumitems() {
		// TODO Auto-generated method stub
		return shoppingdao.count();
	}
//	@Query("SELECT new org.twinnation.site.dto.TitleAndDescriptionAndId(a.title, a.description, a.id) "
//		      + "FROM Article a")
//	public List<Shopp> sumitems();{
//		return 
//	}

	@Override
	public List<Shoppingcart> getinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Shoppingcart> getinfo(Long price) {
		List<Shoppingcart> priceList= shoppingdao.getinfo(price);
//		priceList.forEach(System.out::println);
//		System.out.println(priceList);
//		System.out.print(priceList.get(1));
		System.out.println("This will be List to string conversion output");
		//Created List to print All data from 
		  List<List<Shoppingcart>> list = Arrays.asList(priceList);
	        String delim = "-";
	 
	        StringBuilder sb = new StringBuilder();
	 
	        int i = 0;
	        while (i < list.size() - 1)
	        {
	            sb.append(list.get(i));
	            sb.append(delim);
	            i++;
	        }
	        sb.append(list.get(i));
	 
	        String res = sb.toString();
	        System.out.println("This is res "+ res);
	        
	        //To convert String give spaces
	        String s = res;
	        s = s.replaceAll("\\D+"," ");
	        System.out.println("This is converstion to numbers "+ s);
	        
	        //TO Split a String on any whitespace character in Java
	        
	        String str = s;
	        String[] words = str.split("\\s+");
	        System.out.println("This whitespace convertion");
	        System.out.println(Arrays.toString(words));
	        
	        //To create a list from string for convertion to int
	        List<String> Test = Arrays.asList(words);
	        
//	        System.out.print("It is from string variable TEST"+Test);
	        int sums=0;
	        int gsts=0;
	        for(int i1=0; i1<Test.size();i1++) {
//	        	System.out.print("This is by get"+Test.get(i1));
	            String str11 = Test.get(i1);
		        try{
		            int number = Integer.parseInt(str11);
//		            System.out.println(number); // output = 25
		            //Fining GST of each product
//		            System.out.println("18% of numbers"+number*(18/100.0f));
		            float gstinclude = number*(18/100.0f);
//		            (int)(value*(percentage/100.0f));
		            sums += number;
		            gsts+=gstinclude;
//		            System.out.println(gstinclude);
		         
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		        
	        	
	        }
//	        System.out.print("Total Money to pay "+sums);
//	        System.out.print("Total GST "+gsts);
	        float discount = (sums+gsts)*10/100.0f;
	        float total = sums+gsts;
	        float totalam = total-discount;
	        System.out.println("Total without including GST "+sums);
	        System.out.println("Total Money to pay "+(sums+gsts));
	        System.out.println("Total Money to pay with 10% discount "+totalam);
	     
	        
	     

		return priceList;
		
		
		
		
	}



}
