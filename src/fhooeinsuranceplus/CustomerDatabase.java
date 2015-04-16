package fhooeinsuranceplus;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CustomerDatabase {

	private static List<Customer> listOfCustomers = new ArrayList<Customer>();

	public List<Customer> getListOfCustomers(Staff s) {
		if (s==null) {
			return null;
		}
		
		
		return listOfCustomers;
		
		
	}

	public static void init() {
		
		Customer c1 = new Customer();
		c1.setFirstName("Hans");
		c1.setSurname("Huber");
		c1.setInsuranceSum(1000);

	}

}
