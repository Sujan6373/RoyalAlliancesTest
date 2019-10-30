package com.ra.qa.general;

public class Test1 
{
	double time;
	double principle;;
	double rate;	
	double amount;	
	double n;
	double interest;

	
	public void calCompoundInterest(double p, double rate, double time, double n)
	{
		this.principle = p;
		this.rate = rate;
		this.time = time;
		this.amount = n;
		amount = principle * Math.pow ((1 + rate/100), time);
		//double coumpoundInterest = amount - principle;
		System.out.println("The amount is $" + amount);
	}
	
	
	public static void main (String[] args)
	{
		Test1 calc = new Test1();
		calc.calCompoundInterest(2000, 5, 8, 12);
		
		int[] arr = {0, 1, 2, 3, 4};
		int max = arr[0];
		
		for (int i = 0; i<arr.length; i++)
		{
			if (arr[i]>max)
				max = arr[i];
			
		}
		System.out.println("The highest number is: " + max);
		
		

	}
}
