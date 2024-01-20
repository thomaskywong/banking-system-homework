package com.banking_system.homework;

public interface TransactionInterface {

	/**
	 * @return The account balance for account {@link Transaction#accountNumber}
	 *         .
	 */
	abstract double getBalance();

	/**
	 * @param amount
	 *            The amount to credit/deposit into account
	 *            {@link Transaction#accountNumber}
	 */
	abstract void credit(double amount);

	/**
	 * @param amount
	 *            The amount to debit/withdraw from account
	 *            {@link Transaction#accountNumber}
	 * @return true if amount could be withdrawn; otherwise, return false.
	 */
	abstract boolean debit(double amount);
}
