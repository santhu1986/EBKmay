package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library 
{

	public static WebDriver driver;
	public static String Expval,Actval;
	public static FileInputStream Fis;
	public static Properties PR;
	
	
	public String OpenApp(String URL) throws IOException
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\santh\\Desktop\\geckodriver.exe");
		
		Fis=new FileInputStream("E:\\SeleniumApril\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
		PR=new Properties();
		PR.load(Fis);
		
		 Expval="Ranford Bank";
			
			//Launch Browser
			
		      driver=new FirefoxDriver();
		      
		      //Maximise
		      
		      driver.manage().window().maximize();
		      
		      //url
		      
		      driver.get(URL);
		      
		   Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		      
		    
		     //get title
		      
		     // String Tit=driver.getTitle();
		     // System.out.println(driver.getTitle());

		      //Comparision
		      
		      if (Expval.equalsIgnoreCase(Actval)) 
		      {
			    System.out.println("Application Launch");	
			    
			  }
		      else
		      {
		    	  System.out.println("Application Failed to Launch");
		    	  
		      }
		      return "RHP Is Opened";
		      
		     
	}
	
	public void AdminLgn(String Un,String Pwd)
	{
		
       Expval="Welcome to Admin";
	      
	      driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
	      driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
	      driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
	      
	      Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
	      
		    
             //Comparision
		      
		      if (Expval.equalsIgnoreCase(Actval)) 
		      {
			    System.out.println("Admin Login Succ");	
			  }
		      else
		      {
		    	  System.out.println("Admin Login Failed");
		      }
	    
	}
	
	public String Branches(String Bname,String add1,String zc,String Ctry,String sta,String cty) throws InterruptedException
	{

	      Expval="Sucessfully";
	      
	      driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
	      driver.findElement(By.xpath("//input[contains(@name,'BtnNewBR')]")).click();
	      
	      driver.findElement(By.id("txtbName")).sendKeys(Bname);
	      driver.findElement(By.id("txtAdd1")).sendKeys(add1);
	      
	      driver.findElement(By.id("txtZip")).sendKeys(zc);
	      
	      
	      
	      //Dropdown
	      
	      Select Cry=new Select(driver.findElement(By.id("lst_counrtyU")));
	      Cry.selectByVisibleText(Ctry);
	      
	      new Select(driver.findElement(By.id("lst_stateI"))).selectByVisibleText(sta);
	      
	      new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText(cty);
	      
	      driver.findElement(By.id("btn_insert")).click();
	      
	      //Alert
	    
       Actval= driver.switchTo().alert().getText();
       Thread.sleep(3000);
       driver.switchTo().alert().accept();
       Thread.sleep(2000);
       driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click(); 
       if (Actval.contains(Expval))
       {
			System.out.println("Branch Created");
		 }
       else
       {
      	 System.out.println("Branch Already Exist");
       }
    //Home
    
    
    return Actval;
    

	}
	
	//Roles
	
	public String Role(String RN,String RT) throws InterruptedException
	{
		Expval="Sucessfully";
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		Thread.sleep(4000);
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  
	      }
	      return Actval;
	     }


	//Logout
         public void admlgt()
     
     {
    	 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
    	 
    	 }
    
 //Close
        public void Appc()
     {
    	 driver.close();
     }


	//Employees
	//Log out
	//Close
	
}
