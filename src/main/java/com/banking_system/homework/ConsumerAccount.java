package com.banking_system.homework;

import java.util.Objects;

public class ConsumerAccount extends Account{

	public ConsumerAccount(Person person, Long accountNumber, int pin, double currentBalance) {
		// complete the function
		super(person, accountNumber, pin, currentBalance);
	}

	@Override
	public String toString() {
		return "CustomerAccount(" + super.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;

		if (!(super.equals(obj)))
			return false;
		
		if (!(obj instanceof ConsumerAccount)) 
			return false;

		return true;

	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	

}