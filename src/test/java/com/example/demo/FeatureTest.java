package com.example.demo;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.springframework.web.bind.annotation.ModelAttribute;

public class FeatureTest
{
    @Test
	public void testAnnotationAboveController()
	{
		boolean flag=false;
		try {
		Class cobj=	Class.forName("com.controller.BillController");
		Annotation[] ann=cobj.getAnnotations();
		for(Annotation a:ann)
		{
			if(a.annotationType().getSimpleName().equals("Controller"))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		} catch (ClassNotFoundException e) {
			fail("You have changed the BillController className inside the com.controller package");
		}
		catch(AssertionError e)
		{
			fail("You have not used the appropriate Annotation above the BillController class");
		}
	}
	
	
	
	
	@Test
	public void testDependencyInjection()
	{
		boolean flag=false;
		try {
		Class cobj=	Class.forName("com.controller.BillController");
		Field f=cobj.getDeclaredField("billService");
		Annotation[] ann=f.getAnnotations();
		for(Annotation a:ann)
		{
			if(a.annotationType().getSimpleName().equals("Autowired"))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		} catch (ClassNotFoundException e) {
			fail("You have changed the BillController className inside the com.controller package");
		}
		catch(AssertionError e)
		{
			e.printStackTrace();
			fail("You have not used the appropriate Annotation above the billService attribute in the BillController class");
		} catch (NoSuchFieldException e) {
		
			fail("You have not declared the attribute with the name billService in the BillController class");
		} catch (SecurityException e) {
		
			fail("You have not declared the attribute with the name billService in the BillController class");
		}
	}
	
	
	
	
	@Test
	public void testAnnotationAboveService()
	{
		boolean flag=false;
		try {
		Class cobj=	Class.forName("com.service.BillService");
		Annotation[] ann=cobj.getAnnotations();
		for(Annotation a:ann)
		{
			if(a.annotationType().getSimpleName().equals("Service"))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		} catch (ClassNotFoundException e) {
			fail("You have changed the BillService className inside the com.service package");
		}
		catch(AssertionError e)
		{
			fail("You have not used the appropriate Annotation above the BillService class");
		}
	}
	
	
@Test
  public void testAnnotationsAboveBuildStateMethod()
  {
	  boolean flag=false;
	  try {
	Class cobj=	Class.forName("com.controller.BillController");
	Method method[]=cobj.getMethods();

	for(Method m:method)
	{
		//System.out.println(m.getName());
		
		if(m.getName().equals("buildState")){
		for(Annotation aobj:m.getAnnotations())
		{
		
		if(aobj.annotationType().getName().equals("org.springframework.web.bind.annotation.ModelAttribute")){
		flag=true;
		break;
		}
		
		}
		
	}
	
	}
	
	try
	{
		assertTrue(flag);
	}
	catch(AssertionError e)
	{
		fail("Please use the appropriate Annotation above the buildState method inside the BillController to populate the item name");
	}
	  }
	  
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
   @Test
	public void testAnnotationValueAboveMethod()
	{
		boolean flag=false;
		try {
		Class cobj=	Class.forName("com.controller.BillController");
		Method m=cobj.getMethod("buildState");
	Annotation ann[]=	m.getAnnotations();
		
		for(Annotation a:ann)
		{
			if(a instanceof ModelAttribute) {
		ModelAttribute m1=(ModelAttribute)a;
				
			if(m1.value().equals("itemList"))
			{
				
				flag=true;
				break;
			}
		}
		}
		if(flag==true)
		{
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		} catch (ClassNotFoundException e) {
			fail("You have changed the BillController className inside the com.controller package");
		}
		catch(AssertionError e)
		{
			fail("You have not used the appropriate ModelAttribute name- itemList above the buildState method in the BillController");
		} catch (NoSuchMethodException e) {
			
			fail("You have changed the buildState method inside the BillController");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	}