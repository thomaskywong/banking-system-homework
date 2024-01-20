package com.banking_system.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Account implementation for commercial (business) customers.<br>
 * <br>
 *
 * Private Variables:<br>
 * {@link #authorizedUsers}: List&lt;Person&gt;<br>
 */
public class CommercialAccount extends Account {
	private List<Person> authorizedUsers;

	public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
		super(company, accountNumber, pin, startingDeposit);
		
		this.authorizedUsers = new ArrayList<>();
	}

	/**
	 * @param person The authorized user to add to the account.
	 */
	protected void addAuthorizedUser(Person person) {
		Objects.requireNonNull(person);

		int size = this.authorizedUsers.size();
		for (int i = 0; i < size; i++) {
			if (person.equals(authorizedUsers.get(i))) {
				System.out.println("This person is already an authorized user.");
				return;
			}
		}
	  authorizedUsers.add(person);	
		Collections.sort(authorizedUsers, (e1, e2) -> e2.getIdNumber() > e1.getIdNumber() ? -1 : 1);
	}

	/**
	 * @param person
	 * @return true if person matches an authorized user in
	 *         {@link #authorizedUsers}; otherwise, false.
	 */
	public boolean isAuthorizedUser(Person person) {
		if (person == null)
			return false;

		return this.authorizedUsers.contains(person);
	}

	public List<Person> getAuthorizedUsers () {
		return this.authorizedUsers;
	}

	@Override
	public String toString() {
		return "CommercialAccount(" + super.toString() + ", authorizedUsers=" + this.authorizedUsers + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(super.equals(obj)))
			return false;
		
		if (!(obj instanceof CommercialAccount)) 
			return false;

		CommercialAccount commercialAcc = (CommercialAccount) obj;

		return Objects.equals(commercialAcc.getAuthorizedUsers(), this.authorizedUsers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.authorizedUsers);
	}


}
