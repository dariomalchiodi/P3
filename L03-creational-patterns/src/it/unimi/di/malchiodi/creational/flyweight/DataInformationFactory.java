package it.unimi.di.malchiodi.creational.flyweight;

import java.util.HashMap;

public class DataInformationFactory {
	private HashMap<String, Flyweight> lstFlyweight;
	
	private static DataInformationFactory factory = new DataInformationFactory();
	
	private DataInformationFactory() {
		lstFlyweight = new HashMap<String, Flyweight>();
	}
	
	public synchronized Flyweight getFlyweight(String divisionName) {
		if(lstFlyweight.get(divisionName) == null) {
			Flyweight fw = new DataInformations(divisionName);
			lstFlyweight.put(divisionName, fw);
			return fw;
		} else {
			return lstFlyweight.get(divisionName);
		}
	}
	
	public static DataInformationFactory getInstance() {
		return factory;
	}
	
	private class DataInformations implements Flyweight {
		private String company;
		private String address;
		private String city;
		private String state;
		private String zip;
		
		private void setValues(String company, String address, String city, String state, String zip) {
			this.company = company;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
		}
		
		private DataInformations(String division) {
			if(division.equals("North"))
				setValues("TheCompany", "Address1", "City1", "State", "ZIP");
			
			if(division.equals("South"))
				setValues("TheCompany", "Address2", "City1", "State", "ZIP");
			
			if(division.equals("East"))
				setValues("TheCompany", "Address3", "City1", "State", "ZIP");
			
			if(division.equals("West"))
				setValues("TheCompany", "Address4", "City1", "State", "ZIP");
		}
		
		public String getCompany() {
			return company;
		}
		
		public String getAddress() {
			return address;
		}
		
		public String getCity() {
			return city;
		}
		
		public String getState() {
			return state;
		}
		
		public String getZip() {
			return zip;
		}
	}
}
