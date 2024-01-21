package com.banking_system.homework;
import java.util.Objects;


public abstract class AccountHolder {
	private int idNumber;

	/**
	 * @param idNumber The government-issued ID used during account setup.
	 */
	public AccountHolder(int idNumber) {
    if (idNumber <= 0) {
      throw new IllegalArgumentException("Invalid ID number <= 0. ID number shall be > 0.");
    }
		this.idNumber = idNumber;
	}

	/**
	 * @return private int {@link AccountHolder#idNumber}
	 */
	public int getIdNumber() {
		return this.idNumber;
	}

	// public abstract int getSomething();

	
  @Override
  public String toString(){
    return "AccountHolder(" + "idNumber=" + this.idNumber + ")"; 
  }

  @Override
  public boolean equals(Object obj) {
    
    if (this == obj) 
      return true;
    
    if(!(obj instanceof AccountHolder))
      return false;
    
    AccountHolder accountHolder = (AccountHolder) obj;

    return Objects.equals(this.idNumber, accountHolder.getIdNumber()); 
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.idNumber);
  }


}
