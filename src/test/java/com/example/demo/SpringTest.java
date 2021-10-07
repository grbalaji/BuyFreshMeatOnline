package com.example.demo;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import com.controller.BillController;
import com.model.Item;
import com.service.BillService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringTest {

	 
	
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
   @Mock
   private BillService service;
    
    @InjectMocks
   private BillController ctrl;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
   
       }
   
    @Test
    public void testShowPage(){
    	ResultMatcher ok=MockMvcResultMatchers.status().isOk();
    		
       try {
		this.mockMvc.perform(get("/showPage")).andExpect(ok);
		this.mockMvc.perform(get("/showPage")).andExpect(ok).andExpect(view().name("showpage"));
       	}
       catch (AssertionError e) {
		   if(e.getMessage().contains("View"))
    	   {
    		   fail(e.getMessage());
    	   }
		fail("Request Mapping  to showPage is not done as per the requirement");
       	}
       catch(Exception e)
       {
    	  fail("Request Mapping  to showPage not done as per the requirement");
       }
       
   }
    
    
   @Test
    public void testCalculateTotalBillAmountMethodInvocation()
    {
    	ResultMatcher ok=MockMvcResultMatchers.status().isOk();
    		
    	Item bean=new Item();
        bean.setItemName("Mutton");
        bean.setQuantity(2);
        bean.setRatePerKg(750.0);
        
    	
       try {
		   this.mockMvc.perform(post("/result").flashAttr("item", bean)).andExpect(ok);
		   this.mockMvc.perform(post("/result").flashAttr("item", bean)).andExpect(ok).andExpect(view().name("result"));
		
       	}
       catch (AssertionError e) {
    	   e.printStackTrace();
		   if(e.getMessage().contains("View"))
    	   {
    		   fail(e.getMessage());
    	   }
		fail("Request Mapping from  showPage to result page not done as per the requirement");
       	}
       catch(Exception e)
       { 
    	   e.printStackTrace();
    	   fail("The model attribute item should be as per the requirement");
       }
      
       try {
		   BindingResult result=Mockito.mock(BindingResult.class);
		   ModelMap model=Mockito.mock(ModelMap.class);
	       ctrl.calculateTotalBillAmount(bean,  result,model);
	      verify(service).calculateTotalBillAmount(bean);
       	}
       catch (AssertionError e) {
    	   e.printStackTrace();
		  fail("Invoke the appropriate method of the BillService class inside the BillController as per the requirement");
       	}
       catch(Exception e)
       { 
    	   e.printStackTrace();
    	   fail("The model attribute item should be as per the requirement");
       }
   }
    
    
 @Test
  public void testValidationFlowForInvalidScenario()
  {
  	ResultMatcher ok=MockMvcResultMatchers.status().isOk();
  		

	  Item bean=new Item();
	  BillService service=new BillService();
	  bean.setItemName("Prawns");
   bean.setQuantity(0);
  	
     try {
 		   this.mockMvc.perform(post("/result").flashAttr("item", bean)).andExpect(ok);
 		   this.mockMvc.perform(post("/result").flashAttr("item", bean)).andExpect(ok).andExpect(view().name("showpage"));
 		
     	}
     catch (AssertionError e) {
  	  //e.printStackTrace();
 		   if(e.getMessage().contains("View"))
  	   {
  		   fail(e.getMessage());
  	   }
 		fail("Request Mapping from  showpage during Validation error is not done as per the requirement");
     	}
     catch(Exception e)
     { 
  	   fail("The model attribute should be as per the requirement");
     }
    
   
 }
  
  
}