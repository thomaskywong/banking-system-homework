package com.banking_system.homework;

public interface BankInterface {

	/**
	 * Creates a new account and adds it to {@link Bank#accounts}.
	 *
	 * @param company
	 * @param pin
	 * @param startingDeposit
	 * @return The account number for the newly created account.
	 */
	abstract Long openCommercialAccount(Company company, int pin, double startingDeposit);

	/**
	 * Creates a new account and adds it to {@link Bank#accounts}.
	 *
	 * @param person
	 * @param pin
	 * @param startingDeposit
	 * @return The account number for the newly created account.
	 */
	abstract Long openConsumerAccount(Person person, int pin, double startingDeposit);

	/**
	 * @param accountNumber The account number for the transaction.
	 * @param pin
	 * @return true if authentication was successful.
	 */
	abstract boolean authenticateUser(Long accountNumber, int pin);

	/**
	 * @param accountNumber The account number for the transaction.
	 * @return the balance of the account.
	 */
	abstract double getBalance(Long accountNumber);

	/**
	 * @param accountNumber The account number for the transaction.
	 * @param amount        The amount of money being deposited.
	 */
	abstract void credit(Long accountNumber, double amount);

	/**
	 * @param accountNumber The account number for the transaction.
	 * @param amount
	 * @return true if amount could be withdrawn; otherwise, return false.
	 */
	abstract boolean debit(Long accountNumber, double amount);

	/**
	 * @param accountNumber The account number for the transaction.
	 * @return true if the account can be found by the accountNumber
	 */
	abstract Account getAccount(Long accountNumber);
}
