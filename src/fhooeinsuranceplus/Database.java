package fhooeinsuranceplus;

public class Database {
	
	public boolean authenticateUser(String username) {
		
		if (username.equals("admin")) {
			return true;
		} else {
			return false;
		}
		
	}

}
