package testapp;

import java.util.Scanner;

import rechargeapp.bean.BeanProvider;
import rechargeapp.client.Paytm;

public class TestApplication {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter mobile number");
		long mobNo= scan.nextLong();
		
		System.out.println("Enter service provider name");
		String serviceName = scan.next();
		
		Paytm serviceProvider = BeanProvider.getBean(serviceName);
		
		if(serviceProvider==null)
		{
			System.out.println("you have entered wrong service provider");
		}
		else
		{
			
			System.out.println("available denomination are --------");
			serviceProvider.denomination();
			System.out.println();
			System.out.println("Please enter amount for recharge");
			
			int amt = scan.nextInt();
			
			serviceProvider.recharge(mobNo, amt);
			
			
		}
		
		
		
	}

}
