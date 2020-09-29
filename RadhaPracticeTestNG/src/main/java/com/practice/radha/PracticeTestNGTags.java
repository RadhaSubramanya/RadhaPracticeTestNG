package com.practice.radha;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeTestNGTags {

	@Test(priority=1)
	void Search()
	{
		System.out.println("Searching item...");		
	}
	@Test(priority = 2)
	void addToCart()
	{
		System.out.println("adding to cart...");
		Assert.assertTrue(false, "assert error");
	}
	@Test(priority = 3)
	void makePayment()
	{
		System.out.println("making payment...");
		//Assert.assertTrue(false, "assert error");
	}
	@Test(priority = 4,dependsOnMethods = {"makePayment","addToCart"})
	void checkout()
	{
		System.out.println("checking out...");
	}
	
	@DataProvider(parallel = true)
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		data[0][0]="U1";
		data[0][1]="P1";
		data[0][2]="FF";
		data[0][3]="Pass";
		
		data[1][0]="U2";
		data[1][1]="P2";
		data[1][2]="Chrome";
		data[1][3]="Pass";
		
		data[2][0]="U3";
		data[2][1]="P3";
		data[2][2]="IE";
		data[2][3]="Pass";
		
		return data;
	}
	@Test(dataProvider = "getData")
	void printData(String UN,String PWD,String BRW,String Status)
	{
		System.out.println(UN+" "+PWD+" "+BRW+" "+ Status+"\n");
	}
}
