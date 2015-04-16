package fhooeinsuranceplus;

import java.util.Date;


/**
 * Class Customer: Store everything we want to keep about our cusomers.
 * Name, date of birth, ...
 * 
 * @author Lukas
 *
 */
public class Customer {
	private String firstName;
	private String surname;
	private Date dateOfBirth;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
