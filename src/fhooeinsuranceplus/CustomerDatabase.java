package fhooeinsuranceplus;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {

	private static List<Customer> listOfCustomers = new ArrayList<Customer>();

	public List<Customer> getListOfCustomers(Staff s) {
		if (s == null) {
			return null;
		}

		return listOfCustomers;

	}

	public void addCustomer(Staff s, Customer c) {
		if (s.getRole().equals(StaffRole.AGENT)) {
			listOfCustomers.add(c);
		} else {
			System.out.println("[forbidden]");

		}

		return;
		// TODO
	}

	public void removeCustomer(Staff s, Customer c) {
		System.out.println("[not implemented]");

		return;
		// TODO
	}

	public static void init() {
		System.out.println("[init] Customer Data");

		Customer c1 = new Customer();
		c1.setFirstName("Hans");
		c1.setSurname("Huber");
		c1.setInsuranceSum(1000);
		listOfCustomers.add(c1);
		
		Customer c2 = new Customer();
		c2.setFirstName("Heidi");
		c2.setSurname("Meier");
		c2.setInsuranceSum(7450);
		listOfCustomers.add(c2);
		
		Customer c3 = new Customer();
		c3.setFirstName("Johannes");
		c3.setSurname("Hotz-Plotz");
		c3.setInsuranceSum(15);
		listOfCustomers.add(c3);
		
		Customer c4 = new Customer();
		c4.setFirstName("DDr. Jörg");
		c4.setSurname("Gemeinreich");
		c4.setInsuranceSum(1200000);
		listOfCustomers.add(c4);

		System.out.println(listOfCustomers.size() + " sample entries created");

		//serializeData();

	}
}
//
//	private static void serializeData() {
//
//		try {
//
//			FileOutputStream fileOut = new FileOutputStream(
//					"customers.ser");
//
//			ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			out.writeObject(listOfCustomers);
//			out.close();
//			fileOut.close();
//			System.out
//					.println("Serialized data is saved in customers.ser");
//		} catch (IOException i) {
//			i.printStackTrace();
//		}
//
//	}
//
//	private static List<Customer> deserializeData() {
//
//		List<Customer> customerlist = null;
//		try {
//			FileInputStream fileIn = new FileInputStream(
//					"customers.ser");
//			ObjectInputStream in = new ObjectInputStream(fileIn);
//			customerlist = (List<Customer>) in.readObject();
//			in.close();
//			fileIn.close();
//		} catch (IOException i) {
//			i.printStackTrace();
//			return null;
//		} catch (ClassNotFoundException c) {
//			System.out.println("Customer class not found");
//			c.printStackTrace();
//			return null;
//		}
//		System.out.println("Deserialized Customer list...");
//		System.out.println(customerlist.size() + " entries restored.");
//		return customerlist;
//	}
//
//}
