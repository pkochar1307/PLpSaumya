package com.cg.CapStore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.CapStore.dto.Inventory;
import com.cg.CapStore.service.ICapStoreService;

@Controller
public class CapStoreController 
{
	@Autowired
	ICapStoreService service;
	@RequestMapping(value = "AddProducts",method = RequestMethod.GET)
	public String addProductsMerchants(@ModelAttribute("my") Inventory in,BindingResult result, Map<String, Object> model) {
		
			List<String> myList = new ArrayList<>();
			myList.add("Electronics");
			myList.add("Books");
			myList.add("Footwear");
			model.put("cato", myList);
			 
			List<String> sublist = new ArrayList<>();
			sublist.add("Mobile");
			sublist.add("Laptop");
			sublist.add("Refrigerators");
			model.put("subcato", sublist);
			

			return "AddProducts";
		
	}
	
	@RequestMapping(value = "ProductView", method = RequestMethod.GET)
	public ModelAndView showProducts()
	{
		List<Inventory> prodList = service.getProductList();
		return new ModelAndView("ProductView", "data", prodList);
	}
	
	@RequestMapping(value = "UpdateProducts",method = RequestMethod.GET)
	public ModelAndView updateProducts(@ModelAttribute("yy") Inventory in)
	{
		List<Inventory> prodList = service.getProductList();
		return new ModelAndView("UpdateProducts", "data",prodList);
	}
	
	@RequestMapping(value="ProductUpdate",method=RequestMethod.POST)
	public ModelAndView productUpdate(@ModelAttribute("yy") Inventory in,@RequestParam("product_id") String id)
	{	
		System.out.println(id);		
		return new ModelAndView("ProductUpdate", "data", id);
		
	}
	
	@RequestMapping(value="Success",method=RequestMethod.POST)
	public String Success(@ModelAttribute("yy") Inventory in,@RequestParam("product_id") String id)
	{	
		in.setProduct_id(id);
		
		Inventory invent=service.updateProducts(in);
		System.out.println(invent);
		
		
		return "Success";

	
	}
	
	@RequestMapping(value="Success1",method=RequestMethod.POST)
	public String Success1(@ModelAttribute("yy") Inventory in,@RequestParam("product_id") String id)
	{	
		service.addProducts(in);	
		
		return "Success";
	}
}
