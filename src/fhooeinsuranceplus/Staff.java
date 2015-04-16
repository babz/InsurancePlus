package fhooeinsuranceplus;


/**
 * Store data about our Staff
 * Role ( Agent | Admin | Controller )
 * ID
 * PW Hash
 * 
 * @author Lukas
 *
 */
public class Staff {
	
	
	/**
	 * Role of the Staff member (ADMIN, AGENT, CONTROLLER)
	 */
	private StaffRole role;
	
	/**
	 * An unique id
	 */
	private int id;
	
	/**
	 * Cryptographically secure hasj
	 */
	private String passwordHash;

	/**
	 * @return the role
	 */
	public StaffRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(StaffRole role) {
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	

}
