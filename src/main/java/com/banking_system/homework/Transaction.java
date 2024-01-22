package com.banking_system.homework;

import java.util.Objects;

public class Transaction implements TransactionInterface {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank The bank where the account is housed.
	 * @param accountNumber The customer's account number.
	 * @param attemptedPin The PIN entered by the customer.
	 * @throws Exception Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin)
			throws Exception {
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
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Invalid deposit amount. Amount shall be > 0.");

		this.bank.credit(this.accountNumber, amount);
	}

	@Override
	public boolean debit(double amount) {
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Invalid debit amount. Amount shall be > 0.");

		return bank.debit(this.accountNumber, amount);
	}

	@Override
	public String toString() {
		return "Transaction(accountNumber=" + this.accountNumber + ", bank="
				+ this.bank + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Transaction))
			return false;

		Transaction transaction = (Transaction) obj;

		return Objects.equals(transaction.accountNumber, this.accountNumber)
				&& Objects.equals(transaction.bank, this.bank);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.accountNumber, this.bank);
	}

	// public static void main(String[] args) {

	// 	Person p1 = new Person("Thomas", "Wong", 1);
	// 	Person p2 = new Person("Peter", "Lee", 2);

	// 	Bank b1 = new Bank();
	// 	b1.openConsumerAccount(p1, 9012, 20.0d);
	// 	b1.openConsumerAccount(p2, 3456, 500_000.0d);

	// 	Transaction t1 = null;
	// 	Transaction t2 = null;
	// 	Transaction t3 = null;
	// 	try {
	// 		t1 = new Transaction(b1, 1L, 9012);
	// 		t2 = new Transaction(b1, 1L, 9012);
	// 		t3 = new Transaction(b1, 2L, 3456);
	// 	} catch (Exception ex) {
	// 		System.out.println(ex.getMessage());
	// 	}

	// 	System.out.println();
	// 	System.out.println(t1);
	// 	System.out.println();
	// 	System.out.println(t2);

	// 	System.out.println();
	// 	System.out.println(t1.equals(t2));
	// 	System.out.println(t1.equals(t3));

	// 	System.out.println();
	// 	System.out.println(t1.hashCode());
	// 	System.out.println(t2.hashCode());
	// 	System.out.println(t3.hashCode());

	// }
}
