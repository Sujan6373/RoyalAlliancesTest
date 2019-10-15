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
		amount = principle * Math.pow ((1 + rate/100), time);
		//double coumpoundInterest = amount - principle;
		System.out.println("The amount is $" + amount);
	}
	
	public static void main (String[] args)
	{
		Test1 calc = new Test1();
		calc.calCompoundInterest(2000, 5, 8, 12);
	}
}
