package com.banking_system.homework;

public interface AccountInterface {

	/**
	 * @return The {@link AccountHolder}.
	 */
	abstract AccountHolder getAccountHolder();

	/**
	 * @param attemptedPin The attempted PIN.
	 * @return true if attemptedPin matches the account; otherwise, return false.
	 */
	abstract boolean validatePin(int attemptedPin);

	/**
	 * @return {@link Account#accountBalance}.
	 */
	abstract double getBalance();

	/**
	 * @return {@link Account#accountNumber}
	 */
	abstract Long getAccountNumber();

	/**
	 * @param amount The amount to be deposited into the account.
	 */
	abstract void creditAccount(double amount);

	/**
	 * @param amount The amount to be withdrawn from the account.
	 * @return true if amount could be withdrawn; otherwise, return false.
	 */
	abstract boolean debitAccount(double amount);

	/**
	 * {@link Account#pin}.
	 */
	abstract int getPin();
}
