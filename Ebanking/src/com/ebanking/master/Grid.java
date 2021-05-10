package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid 
{
      DesiredCapabilities Cap;
      @Parameters("Browser")
      @Test
      public void Grd(String Br) throws MalformedURLException, InterruptedException 
      {
    	  
    	  if (Br.equalsIgnoreCase("firefox"))
    	  {
    		    Cap=new DesiredCapabilities();
    	    	Cap.setBrowserName("firefox");
    	    	Cap.setPlatform(Platform.WINDOWS);
    	    		
		  }
    	  else if (Br.equalsIgnoreCase("chrome")) 
    	  {
    		  Cap=new DesiredCapabilities();
    	    	Cap.setBrowserName("chrome");
    	    	Cap.setPlatform(Platform.WINDOWS);
    	    	
		  }
    		  
    	
    	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.44.1:4444/wd/hub"),Cap);
    	
    	driver.manage().window().maximize();
    	
        driver.get("http://122.175.8.158/ranford2");
		
		//Login
		
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.Login();
		
		 AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
			AHP.Rol();
			
			//Role details 
			
			RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
			RD.Nrole();
			Thread.sleep(3000);
			//Role Creation
			
			Rolecreation Rcreation=PageFactory.initElements(driver,Rolecreation.class);
			Rcreation.Rcre("abcdcashierg","E");
			
			Thread.sleep(3000);
			//Alert
			
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			//Home
			
			RD.Hom();

    	
      }
}
