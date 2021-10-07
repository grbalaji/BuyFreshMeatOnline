package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.Item;
import com.service.BillService;

@RunWith(SpringRunner.class)
public class FunctionalTest {
       //To check the business logic of calculateTotalCost method in the service class
    @Test
   public void testCalculateTotalBillAmountMethodForTheItemMutton()
    {
	  Item bean=new Item();
	  BillService service=new BillService();
	  bean.setItemName("Mutton");
      bean.setQuantity(3);
     // bean.setRatePerKg(750.0);
          double result2=service.calculateTotalBillAmount(bean);
         
    
	  try{
		  
		  if(result2==2025.0)
			  assertTrue(true);
		  else
			  assertTrue(false);
		
		
	  }
	  catch (AssertionError e) {
   	   
		  fail("Business logic is not as per the requirement for the item Mutton");
      	}
	 
    }
    
  @Test
  public void testCalculateTotalBillAmountMethodForTheItemChicken()
   {
	  Item bean=new Item();
	  BillService service=new BillService();
	  bean.setItemName("Chicken");
     bean.setQuantity(3);
   //  bean.setRatePerKg(750.0);
         double result2=service.calculateTotalBillAmount(bean);
        
   
	  try{
		  
		  if(result2==621.0)
			  assertTrue(true);
		  else
			  assertTrue(false);
		
		
	  }
	  catch (AssertionError e) {
  	   
		  fail("Business logic is not as per the requirement for the item Chicken");
     	}
	 
   }
  @Test
  public void testCalculateTotalBillAmountMethodForTheItemPrawns()
   {
	  Item bean=new Item();
	  BillService service=new BillService();
	  bean.setItemName("Prawns");
     bean.setQuantity(5);
   //  bean.setRatePerKg(750.0);
         double result2=service.calculateTotalBillAmount(bean);
        
   
	  try{
		  
		  if(result2==1360.0)
			  assertTrue(true);
		  else
			  assertTrue(false);
		
		
	  }
	  catch (AssertionError e) {
  	   
		  fail("Business logic is not as per the requirement for the item Prawns");
     	}
	 
   }
 
}