package com.banking_system.homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin,
			double startingDeposit) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	@Override
	public AccountHolder getAccountHolder() {
		return this.accountHolder;
	}

	@Override
	public boolean validatePin(int attemptedPin) {
		return this.getPin() == attemptedPin;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public int getPin() {
		return this.pin;
	}

	@Override
	public Long getAccountNumber() {
		return this.accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		this.balance = BigDecimal.valueOf(this.balance).add(BigDecimal.valueOf(amount)).doubleValue();
	}

	@Override
	public boolean debitAccount(double amount) {
		if (amount > this.balance) {
			System.out.println("Insufficient Fund. Debit cannot proceed.");
			return false;
		}

		this.balance = BigDecimal.valueOf(this.balance).subtract(BigDecimal.valueOf(amount)).doubleValue();

		return true;
	}

	@Override
	public String toString() {

		return "Account(accountHolder=" + this.accountHolder.toString() 
					 + ", accountNumber=" + this.accountNumber 
					 + ", pin=" + this.pin
					 + ", balance=" + this.balance
					 + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Account))
			return false;
		
		Account account = (Account) obj;

		return Objects.equals(this.accountHolder, account.getAccountHolder())
		       && Objects.equals(this.accountNumber, account.getAccountNumber())
					 && Objects.equals(this.pin, account.getPin())
					 && Objects.equals(this.balance, account.getBalance());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.accountHolder, this.accountNumber, this.pin, this.balance);
	}

}
