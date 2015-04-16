package fhooeinsuranceplus;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	static List<Staff> listOfStaff = new ArrayList<Staff>();
	PasswordUtil p = new PasswordUtil();

	public boolean authenticateUser(String username, char[] password) {
		boolean authenticated = false;
		Staff s = null;
		
		for (Staff staffMember : listOfStaff) {
			if (!authenticated && staffMember.getUsername().equals(username)) {
				try {
					if (staffMember.getPasswordHash().equals(
							p.savePassword(password))) {
						authenticated = true;
						s = staffMember;
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} 
		}

		if (s == null) {
			System.out.println("Authentication failed!");
			String wrongPW = new String(password);
			System.out.println("["+username+"]["+wrongPW+"]");
			
			return false;
		} else {
			System.out.println(" User " + s.getId()
					+ " authenticated with role " + s.getRole().toString());
			return true;
		}
	}

	public static void init() {
		PasswordUtil p = new PasswordUtil();

		char[] s1pass = { 'P', 'a', 's', 's', 'w', 'o', 'r', 't' };
		String passHash = "";
		try {
			passHash = p.savePassword(s1pass);

			Staff s1 = new Staff();
			s1.setId(1);
			s1.setRole(StaffRole.ADMIN);
			s1.setUsername("admin");
			s1.setPasswordHash(passHash);

			Staff s2 = new Staff();
			s2.setId(2);
			s2.setRole(StaffRole.AGENT);
			s2.setUsername("agent");
			s2.setPasswordHash(passHash);

			Staff s3 = new Staff();
			s3.setId(3);
			s3.setUsername("controller");
			s3.setRole(StaffRole.CONTROLLER);
			s3.setPasswordHash(passHash);

			listOfStaff.add(s1);
			listOfStaff.add(s2);
			listOfStaff.add(s3);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
