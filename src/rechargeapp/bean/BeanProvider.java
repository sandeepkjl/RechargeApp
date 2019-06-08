package rechargeapp.bean;

import rechargeapp.client.Paytm;
import rechargeapp.service.Airtel;
import rechargeapp.service.Idea;
import rechargeapp.service.Jio;
import rechargeapp.service.Vodafone;

public class BeanProvider {
	
	public static Paytm getBean(String name)
	{
		if(name.equalsIgnoreCase("Airtel"))
			return new Airtel();
		if(name.equalsIgnoreCase("Vodafone"))
			return new Vodafone();
		if(name.equalsIgnoreCase("Idea"))
			return new Idea();
		if(name.equalsIgnoreCase("Jio"))
			return new Jio();
		
		//if wrong service provider choosen
		return null;
	}

}
