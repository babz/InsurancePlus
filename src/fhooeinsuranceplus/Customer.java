package fhooeinsuranceplus;


/**
 * Class Customer: Store everything we want to keep about our cusomers.
 * Name, date of birth, ...
 * 
 * @author Lukas
 *
 */
public class Customer implements java.io.Serializable {
	/**
	 * 
	 */
  private static final long serialVersionUID = 1L;
	private String firstName;
	private String surname;
	private long insuranceSum;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * @return the insuranceSum
	 */
	public long getInsuranceSum() {
		return insuranceSum;
	}
	/**
	 * @param insuranceSum the insuranceSum to set
	 */
	public void setInsuranceSum(long insuranceSum) {
		this.insuranceSum = insuranceSum;
	}
	

}
