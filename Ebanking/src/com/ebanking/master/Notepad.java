package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
	
		//Instance Class
		
				Library LB=new Library();
				
				LB.OpenApp("http://122.175.8.158/ranford2");
				LB.AdminLgn("Admin","Testing@");
				
				// To get Test data File Path
				
				String Fpath="E:\\SeleniumApril\\Ebanking\\src\\com\\ebanking\\testdata\\Role.txt";
				
				//Results File path
				
				String Rpath="E:\\SeleniumApril\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.txt";
				
				String SD;
				
				//To get test data file
				
				FileReader FR=new FileReader(Fpath);
				BufferedReader BR=new BufferedReader(FR);
				String Sread=BR.readLine();
				System.out.println(Sread);
				
				//To write Header into results file
				
				FileWriter FW=new FileWriter(Rpath);
				BufferedWriter BW=new BufferedWriter(FW);
				BW.write(Sread);
				BW.newLine();
				
			  //Multiple Iterations ----Loop(While)
				
				while ((SD=BR.readLine())!=null) 
				{
					System.out.println(SD);
					
					//Split
					
					String SR[]=SD.split("###");
					
					String Rname=SR[0];
					String Rty=SR[1];
					
					String Res=LB.Role(Rname,Rty);
					
					//Results file
					
					BW.write(SD+"&&&&&"+Res);
					BW.newLine();
				}
				BW.close();
				BR.close();
				
			}

}
