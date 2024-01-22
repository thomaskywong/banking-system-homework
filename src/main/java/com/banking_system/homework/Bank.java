package com.banking_system.homework;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Bank implements BankInterface {

	private LinkedHashMap<Long, Account> accounts;
	private static long accNumCount = 0L;

	public Bank() {
		this.accounts = new LinkedHashMap<>();
	}

	@Override
	public Account getAccount(Long accountNumber) {
		if (!(this.accounts.containsKey(accountNumber)))
			throw new IllegalArgumentException("Invalid account number.");

		return this.accounts.get(accountNumber);
	}

	@Override
	public Long openCommercialAccount(Company company, int pin,
			double startingDeposit) {

		Objects.requireNonNull(company);

		if (pin <= 0)
			throw new IllegalArgumentException(
					"Invalid pin number. Pin number shall be > 0.");

		if (startingDeposit < 0)
			throw new IllegalArgumentException(
					"Invalid deposit amount. Amount shall be >= 0.");

		CommercialAccount account = new CommercialAccount(company,
				++Bank.accNumCount, pin, startingDeposit);
		this.accounts.put(Bank.accNumCount, account);

		return Bank.accNumCount;
	}

	@Override
	public Long openConsumerAccount(Person person, int pin,
			double startingDeposit) {

		Objects.requireNonNull(person);

		if (pin <= 0)
			throw new IllegalArgumentException(
					"Invalid pin number. Pin number shall be > 0.");

		if (startingDeposit < 0)
			throw new IllegalArgumentException(
					"Invalid deposit amount. Amount shall be >= 0.");

		ConsumerAccount account =
				new ConsumerAccount(person, ++accNumCount, pin, startingDeposit);
		this.accounts.put(accNumCount, account);

		return accNumCount;
	}

	@Override
	public boolean authenticateUser(Long accountNumber, int pin) {
		return this.getAccount(accountNumber).validatePin(pin);
	}

	@Override
	public double getBalance(Long accountNumber) {
		return this.getAccount(accountNumber).getBalance();
	}

	@Override
	public void credit(Long accountNumber, double amount) {
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Invalid deposit amount. Amount shall be > 0.");

		this.getAccount(accountNumber).creditAccount(amount);
	}

	@Override
	public boolean debit(Long accountNumber, double amount) {
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Invalid debit amount. Amount shall be > 0.");

		if (amount > this.getAccount(accountNumber).getBalance()) {
			System.out.println("Insufficient fund in account.");
			return false;
		}

		this.getAccount(accountNumber).debitAccount(amount);

		return true;
	}

	@Override
	public String toString() {
		return "Bank(Accounts=" + this.accounts + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Bank))
			return false;

		Bank bank = (Bank) obj;

		return Objects.equals(this.accounts, bank.accounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.accounts);
	}

	// public static void main(String[] args) {
		
	// 	Person p1 = new Person("Thomas", "Wong", 1);
	// 	Person p2 = new Person("Peter", "Lee", 2);


	// 	Company c1 = new Company("ABC company", 1);
	// 	Company c2 = new Company("DEF company", 2);

	// 	Bank b1 = new Bank();
	// 	b1.openCommercialAccount(c1, 1234, 100_000.0);
	// 	b1.openCommercialAccount(c2, 5678, 200_000.0);
	// 	b1.openConsumerAccount(p1, 9012, 0.0d);

	// 	System.out.println();
	// 	System.out.println(b1);

	// 	Bank b2 = new Bank();
	// 	b2.openCommercialAccount(c1, 1234, 100_000.0);
	// 	b2.openCommercialAccount(c2, 5678, 200_000.0);
	// 	b2.openConsumerAccount(p1, 9012, 0.0d);

	// 	System.out.println();
	// 	System.out.println(b2);

	// 	System.out.println(b1.hashCode());
	// 	System.out.println(b2.hashCode());

	// 	System.out.println(b1.equals(b2));
	// 	System.out.println(b1.equals(b1));
	// }
}
