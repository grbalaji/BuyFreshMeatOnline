package com.service;

import org.springframework.stereotype.Service;

import com.model.Item;

@Service
public class BillService {
	
	public double calculateTotalBillAmount (Item item)
	{
		double totalCost=0.0,itemCost;
		if(item.getItemName().equalsIgnoreCase("Mutton"))
		{
			item.setRatePerKg(750.0);
			if(item.getQuantity()==1)
			{
				totalCost=item.getQuantity()*item.getRatePerKg();
			}
			else if(item.getQuantity()>1 && item.getQuantity()<=3)
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*10)/100.0);
			}
			else
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*15)/100.0);
			}
		}
		else if(item.getItemName().equalsIgnoreCase("Chicken"))
		{
			item.setRatePerKg(230.0);
			if(item.getQuantity()==1)
			{
				totalCost=item.getQuantity()*item.getRatePerKg();
			}
			else if(item.getQuantity()>1 && item.getQuantity()<=3)
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*10)/100.0);
			}
			else
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*15)/100.0);
			}
		}
		else
		{
			item.setRatePerKg(320.0);
			if(item.getQuantity()==1)
			{
				totalCost=item.getQuantity()*item.getRatePerKg();
			}
			else if(item.getQuantity()>1 && item.getQuantity()<=3)
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*10)/100.0);
			}
			else
			{
				itemCost=item.getQuantity()*item.getRatePerKg();
				totalCost=itemCost-((itemCost*15)/100.0);
			}
		}
		return totalCost;
	}

}
