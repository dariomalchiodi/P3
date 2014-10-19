package it.unimi.di.malchiodi.serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;


public class PersistentTime implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9120452404539641855L;
	private Date time;
	
	public PersistentTime() {
		time = Calendar.getInstance().getTime();
		System.out.println("ho creato un'istanza di PersistentTime");
	}
	
	public Date getTime() {
		return time;
	}
	
}
