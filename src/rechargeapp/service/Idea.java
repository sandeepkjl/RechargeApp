package rechargeapp.service;

import java.util.HashMap;
import java.util.Map;

import rechargeapp.client.Paytm;
import rechargeapp.exception.InvalidAmountException;
import rechargeapp.exception.InvalidMobileNumberException;

public class Idea implements Paytm{
	
	public static Map<Long, Integer> registeredMobileNumbers = 
			new HashMap<Long, Integer>();
	
	
	
	static{
		
		registeredMobileNumbers.put(7706790623l,200);
		registeredMobileNumbers.put(8965745136l,500);
		registeredMobileNumbers.put(9865235264l,20);
		registeredMobileNumbers.put(9655123252l,200);
	}
	
	

	@Override
	public void recharge(long mobNo, int amt) {
		
		try{
			if(amt>500 || amt<10)
				throw new InvalidAmountException("Recharge Amount Should be greater than 10 and less than 500");
			if(registeredMobileNumbers.containsKey(mobNo)==false)
			{
				throw new InvalidMobileNumberException("Mobile is not registerd with this operator");
			}
			registeredMobileNumbers.put(mobNo, registeredMobileNumbers.get(mobNo)+amt);
			
			//check balance
		System.out.println("Recharge succesfull");
		System.out.println();
		System.out.println();
		System.out.println("available balance is ---");
		balEnquiry(mobNo);
						
		}
		catch(InvalidAmountException | InvalidMobileNumberException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void denomination() {
		
		System.out.println("165 Rs for 1 month free unlimited call and 1 GB data per day");
		System.out.println("398 Rs for 3 month free unlimited call and 1.5 GB data per day");
		System.out.println("50 Rs top up recharge for balance 48.50 ");
		System.out.println("20 Rs top up recharge for balance 10.40");
		System.out.println("100 rs for 3 GB 3G data for 1 month");
		
	}
	
	public void balEnquiry(long mobNo)
	{
		if(registeredMobileNumbers.containsKey(mobNo))
		System.out.println(registeredMobileNumbers.get(mobNo));
		else{
			try{
				throw new InvalidMobileNumberException("Mobile Not Registered with Operator");
			}
			catch(InvalidMobileNumberException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
