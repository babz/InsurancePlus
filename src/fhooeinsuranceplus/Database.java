package fhooeinsuranceplus;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class Database {
	
	List<Staff> listOfStaff = new ArrayList<Staff>();
	
	public boolean authenticateUser(String username, String password) {
		
		if (username.equals("admin")) {
			return true;
		} else {
			return false;
		}
		
	}

	public static void init() {
		PasswordUtil p = new PasswordUtil();
		char[] s1pass = {'P','a','s','s','w','o','r','t'};
		String passHash = "";
		try {
			passHash = p.savePassword(s1pass);
			
			Staff s1 = new Staff();
			s1.setId(1);
			s1.setRole(StaffRole.ADMIN);
			s1.setPasswordHash(passHash);
			

			Staff s2 = new Staff();
			s2.setId(2);
			s2.setRole(StaffRole.AGENT);
			s2.setPasswordHash(passHash);
			
			Staff s3 = new Staff();
			s3.setId(3);
			s3.setRole(StaffRole.CONTROLLER);
			s3.setPasswordHash(passHash);
			
			
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
