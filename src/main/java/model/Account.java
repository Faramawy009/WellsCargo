package model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
	public enum AccountType {
		Savings,
		Checking,
		Mortgage
	}

	private AccountType accType;
	private String accName;
	private int balance;

	public Account(AccountType accType, String accName, int balance) {
		this.accType = accType;
		this.accName = accName;
		this.balance = balance;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object o){
		Account other = (Account)o;
		return this.accName.equals(other.accName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accName, accType);
	}
}
