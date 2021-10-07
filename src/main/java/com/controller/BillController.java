package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Item;
import com.service.BillService;

@Controller
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(value = "/showPage", method = RequestMethod.GET)
	public String showPage(@ModelAttribute("item") Item item)
	{
		return "showpage";
	}
	
	@ModelAttribute("itemList")
	public  Map<String, String> buildState(){
		
		Map<String, String> serviceMap = new HashMap<String, String>();
		serviceMap.put("Mutton", "Mutton");
		serviceMap.put("Chicken", "Chicken");
		serviceMap.put("Prawns", "Prawns");
		return serviceMap;                     
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String calculateTotalBillAmount(@Valid @ModelAttribute("item") Item item, 
			BindingResult result,ModelMap map)
	{
		if(result.hasErrors()) {
			return "showpage";
	}
		else
		{
		double cost=billService.calculateTotalBillAmount(item);
		map.addAttribute("cost",cost);
		return "result";
		
		}		
	}
}
