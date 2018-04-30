import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UserDB implements Serializable{
	public static int ACCOUNT_NOT_FOUND_ERROR = 1;
	public static int ACCOUNT_NOT_ZERO_ERROR = 2;
	public static int INSUFFICIENT_FUNDS = 3;
	public static int SUCCESS = 0;
	private static HashMap<String, User> users;

	static {
		users = new HashMap<>();
	}
	public static void readDB (String filePath) throws Exception{
		FileInputStream fileIn = new FileInputStream(filePath);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		users = (HashMap<String, User>) objectIn.readObject();
	}

	public static void writeDB (String filePath) throws Exception {
		File file = new File(filePath);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(users);
	}

	public static HashMap<String, User> getUsers(){
		return users;
	}

	public static void setUsers(HashMap<String, User> users){
		UserDB.users = users;
	}

	public static User getUser(String userName) {
		return users.get(userName);
	}

	public static void addUser(String userName, String password) {
		users.put(userName, new User(userName, password));
	}

	public static boolean addAccount(String userName, String accName, Account.AccountType accType) {
		return users.get(userName).addAccount(accName, accType);
	}

	public static int removeAccount(String userName, String accName, Account.AccountType accType) {
		User holder = users.get(userName);
		Account acc = holder.getAccounts().get(accName);
		if(acc == null) {
			return ACCOUNT_NOT_FOUND_ERROR;
		}
		int accBalance = acc.getBalance();
		if(accBalance != 0) {
			return ACCOUNT_NOT_ZERO_ERROR;
		}
    holder.getAccounts().remove(accName);
		return SUCCESS;
	}

	public static boolean deposit(String userName, String accName, int amount) {
		Account acc = users.get(userName).getAccounts().get(accName);
		if(acc == null) {
			return false;
		}
		acc.setBalance(acc.getBalance() + amount);
		return true;
	}

	public static boolean withdraw(String userName, String accName, int amount) {
		Account acc = users.get(userName).getAccounts().get(accName);
		if(acc == null) {
			return false;
		}
		acc.setBalance(acc.getBalance() - amount);
		return true;
	}


	public static int transferMoney(String userName, String acc1Name, String acc2Name, int amount) {
		User holder = users.get(userName);
		Account acc1 = holder.getAccounts().get(acc1Name);
		Account acc2 = holder.getAccounts().get(acc2Name);
		if(acc1 == null || acc2 == null) {
			return ACCOUNT_NOT_FOUND_ERROR;
		}
		if(acc1.getBalance() < amount) {
			return INSUFFICIENT_FUNDS;
		}
		acc1.setBalance(acc1.getBalance()-amount);
		acc2.setBalance(acc2.getBalance()+amount);
		return SUCCESS;
	}

	public static String printUserBalance(String userName) {
		User holder = users.get(userName);
		StringBuilder sb = new StringBuilder();
		int balances = 0;
		sb.append("Hello ");
		sb.append(userName);
		sb.append("\n");
		sb.append("Here's a list of your balances:\n");
		for (Map.Entry<String, Account> entry : holder.getAccounts().entrySet()) {
			sb.append(entry.getKey());
			sb.append(": ");
			sb.append(entry.getValue().getAccType().toString());
			sb.append(": ");
			sb.append(entry.getValue().getBalance());
			sb.append("\n");
			balances += entry.getValue().getBalance();
		}
		sb.append("Your total balance is: ");
		sb.append(balances);
		sb.append("\n");
		return sb.toString();
	}
}
