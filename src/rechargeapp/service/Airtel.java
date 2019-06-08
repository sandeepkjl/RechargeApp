package rechargeapp.service;

import java.util.HashMap;
import java.util.Map;

import rechargeapp.client.Paytm;
import rechargeapp.exception.InvalidAmountException;
import rechargeapp.exception.InvalidMobileNumberException;

public class Airtel implements Paytm{
	
	public static Map<Long, Integer> registeredMobileNumbers = 
			new HashMap<Long, Integer>();
	
	
	
	static{
		
		registeredMobileNumbers.put(7607090405l,200);
		registeredMobileNumbers.put(7788665564l,500);
		registeredMobileNumbers.put(9956652332l,20);
		registeredMobileNumbers.put(9965412321l,200);
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
		
		System.out.println("149 Rs for 1 month free unlimited call and 1 GB data per day");
		System.out.println("378 Rs for 3 month free unlimited call and 1.5 GB data per day");
		System.out.println("50 Rs top up recharge for balance 48.50 ");
		System.out.println("20 Rs top up recharge for balance 10.40");
		
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
