package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebTest {
	private static  WebDriver driver;
	private static String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
    private static String port="";
    private static String url="";
    
  	@BeforeClass
	public static void setUp() {
//	    String port1=System.getenv("USER");
//		port=port1.substring(0);
		try
		{
			driver = new HtmlUnitDriver();
		    baseUrl ="";
                url="http://localhost:9072/showPage";
				driver.get(url);
	    }
		catch(Exception e){
			e.printStackTrace();
			fail("Check for the file showPage.jsp or Syntax of JavaScript / CSS / HTML");
		}
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void test01ShowPageJSP() throws Exception{
		try{
			try{
				
				boolean flag=false;
				WebElement e=driver.findElement(By.id("itemName"));
				Select dropdown= new Select(e);
				assertEquals(true, e.isDisplayed());
				List<WebElement> options=dropdown.getOptions();
				for(WebElement option:options)
				{
					System.out.println(option.getText());
					if(option.getText().equals("Mutton")||option.getText().equals("Chicken")||option.getText().equals("Prawns"))
					flag=true;
					else
					{
						flag=false;
						break;
					}
				}
				
				
				assertTrue(flag);
			
			}
			catch(Error e){
				e.printStackTrace();
				fail("Correct HTML Component with the id 'itemName' must be used with appropriate constraints");
				
			}
			catch(Exception e){
				e.printStackTrace();
				fail("Correct HTML Component with the id 'itemName' must be used with appropriate constraints");
				
			}
		}
		catch(Exception e){
			fail("Should have got a tag with the id - itemName");
		}
	
	
	
	
	
}
	
	@Test
	public void test02ShowPageJSP() throws Exception{
	
	try{
		try{
			WebElement e=driver.findElement(By.id("quantity"));
			assertEquals("text", e.getAttribute("type"));
		//	assertEquals("true",e.getAttribute("required"));
			//assertEquals("User Name",e.getAttribute("placeholder")); 
		}
		catch(Error e){
			fail("Correct HTML Component with the id 'quantity' must be used with appropriate constraints");
			
		}catch(Exception e){
			fail("Correct HTML Component with the id 'quantity' must be used with appropriate constraints");
			
		}
	}
	catch(Exception e){
		fail("Should have got a tag with the id - quantity");
	}
	
	
}
	
	@Test
	public void test03SuccessFlowForMutton(){
		try{
			try{
				driver.get(url);
				WebElement mySelectElement = driver.findElement(By.id("itemName"));
				Select dropdown= new Select(mySelectElement);
				dropdown.selectByVisibleText("Mutton");
			/*	driver.findElement(By.name("userName")).clear();
				driver.findElement(By.name("userName")).sendKeys("sudha.0");*/
				driver.findElement(By.id("quantity")).clear();
				driver.findElement(By.id("quantity")).sendKeys("1");
				driver.findElement(By.name("submit")).click();
				try{
					try{
						WebElement element = driver.findElement(By.tagName("h2"));
						
						assertEquals("Thanks for reaching us!!!! Total amount to be paid is Rs.750.0", element.getText());
					}
					catch(Error e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Mutton");
					}
					catch(Exception e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Mutton");
					}
				}
				catch(Exception e){
					fail("Should have got result.jsp");
				}
			}
			catch(Exception e){
			//	System.out.println(e);
				fail("Correct HTML Component with the id 'itemName / quantity' must have appropriate name");
				
			}
		}catch(Exception e){
			fail("Should have got proper element "+e.getMessage());
		}
		
	}
	
	@Test
	public void test04SuccessFlowForChicken(){
		try{
			try{
				driver.get(url);
				WebElement mySelectElement = driver.findElement(By.id("itemName"));
				Select dropdown= new Select(mySelectElement);
				dropdown.selectByVisibleText("Chicken");
			/*	driver.findElement(By.name("userName")).clear();
				driver.findElement(By.name("userName")).sendKeys("sudha.0");*/
				driver.findElement(By.id("quantity")).clear();
				driver.findElement(By.id("quantity")).sendKeys("2");
				driver.findElement(By.name("submit")).click();
				try{
					try{
						WebElement element = driver.findElement(By.tagName("h2"));
						
						assertEquals("Thanks for reaching us!!!! Total amount to be paid is Rs.414.0", element.getText());
					}
					catch(Error e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Chicken");
					}
					catch(Exception e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Chicken");
					}
				}
				catch(Exception e){
					fail("Should have got result.jsp");
				}
			}
			catch(Exception e){
			//	System.out.println(e);
				fail("Correct HTML Component with the id 'itemName / quantity' must have appropriate name");
				
			}
		}catch(Exception e){
			fail("Should have got proper element "+e.getMessage());
		}
		
	}
	
	
	@Test
	public void test05SuccessFlowForPrawns(){
		try{
			try{
				driver.get(url);
				WebElement mySelectElement = driver.findElement(By.id("itemName"));
				Select dropdown= new Select(mySelectElement);
				dropdown.selectByVisibleText("Prawns");
			/*	driver.findElement(By.name("userName")).clear();
				driver.findElement(By.name("userName")).sendKeys("sudha.0");*/
				driver.findElement(By.id("quantity")).clear();
				driver.findElement(By.id("quantity")).sendKeys("4");
				driver.findElement(By.name("submit")).click();
				try{
					try{
						WebElement element = driver.findElement(By.tagName("h2"));
						
						assertEquals("Thanks for reaching us!!!! Total amount to be paid is Rs.1088.0", element.getText());
					}
					catch(Error e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Prawns");
					}
					catch(Exception e){
						fail("Your Business Logic does not give the required output as expected in the UI for the item Prawns");
					}
				}
				catch(Exception e){
					fail("Should have got result.jsp");
				}
			}
			catch(Exception e){
			//	System.out.println(e);
				fail("Correct HTML Component with the id 'itemName / quantity' must have appropriate name");
				
			}
		}catch(Exception e){
			fail("Should have got proper element "+e.getMessage());
		}
		
	}
	  
	    

}
