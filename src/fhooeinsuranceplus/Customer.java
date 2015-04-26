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
    private int custromerId;
	private String firstName;
	private String surname;
	private long insuranceSum;
	private double income;
	
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
	/**
	 * @return the custromerId
	 */
	public int getCustromerId() {
		return custromerId;
	}
	/**
	 * @param custromerId the custromerId to set
	 */
	public void setCustromerId(int custromerId) {
		this.custromerId = custromerId;
	}
	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}
	

}
