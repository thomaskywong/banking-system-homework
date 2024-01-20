package com.banking_system.homework;

import java.util.Objects;

public class Transaction implements TransactionInterface{
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *                      The bank where the account is housed.
	 * @param accountNumber
	 *                      The customer's account number.
	 * @param attemptedPin
	 *                      The PIN entered by the customer.
	 * @throws Exception
	 *                   Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		Objects.requireNonNull(bank);

		if (!(bank.authenticateUser(accountNumber, attemptedPin)))
			throw new IllegalArgumentException("Invalid account number or pin.");

		this.accountNumber = accountNumber;
		this.bank = bank;
	}

	@Override
	public double getBalance() {
		return this.bank.getBalance(this.accountNumber);
	}

	@Override
	public void credit(double amount) {
		if(amount <= 0) 
			throw new IllegalArgumentException("Invalid deposit amount. Amount shall be > 0");
		
		this.bank.credit(this.accountNumber, amount);
	}

	@Override
	public boolean debit(double amount) {
		if(amount <= 0) 
			throw new IllegalArgumentException("Invalid debit amount. Amount shall be > 0");
		
		return bank.debit(this.accountNumber, amount);
	}
}
