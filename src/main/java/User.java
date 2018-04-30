import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class User implements Serializable{
	private String userName;
	private String password;
	private HashMap<String, Account> accounts;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
		accounts = new HashMap<>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<String, Account> getAccounts() {
		return accounts;
	}

	public boolean addAccount(String accName, Account.AccountType accType) {
		if (accounts.containsKey(accName)) {
			//Account with same name already exists
			return false;
		}
		this.accounts.put(accName, new Account(accType, accName,0));
		return true;
	}

	@Override
	public boolean equals(Object o) {
		User other = (User) o;
		return this.userName.equals(other.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

}
