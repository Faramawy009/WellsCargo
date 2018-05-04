package model;

public class TestMain {
	public static void main(String ... args) throws Exception {
//		UserDB.users = new HashMap<>();
//		UserDB.addUser("7onsh", "3rs");
//		UserDB.addUser("Faramnsh", "Shenf");
//		UserDB.addAccount("7onsh", "myChecking", Account.AccountType.Checking);
//		UserDB.addAccount("Faramnsh", "mySavings", Account.AccountType.Savings);
//		UserDB.addAccount("7onsh", "mySavings", Account.AccountType.Savings);
//		UserDB.deposit("7onsh","mySavings", 10000002);
//		UserDB.deposit("Faramnsh","mySavings", 10000003);
//
//		File file = new File("Users.db");
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//		out.writeObject(UserDB.getUsers());
//
//		out.flush();
//		out.close();
//		System.out.println("Object written to file");
//
//
//		FileInputStream fileIn = new FileInputStream("Users.db");
//		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//		HashMap<String, User> readUsers = (HashMap<String, User>) objectIn.readObject();
//		for(Map.Entry<String,User> entry: readUsers.entrySet()) {
//			for(Map.Entry<String, Account> entry1: entry.getValue().getAccounts().entrySet()) {
//				System.out.println(entry.getKey() + " : " + entry1.getKey() + " : " + entry1.getValue().getAccType() + " : " + entry1.getValue().getBalance());
//			}
//		}

		UserDB.readDB("Users.db");
		UserDB.deposit("7onsh","mySavings", 50);
		UserDB.writeDB("Users.db");
		UserDB.readDB("Users.db");
		System.out.println(UserDB.printUserBalance("7onsh"));
		System.out.println(UserDB.printUserBalance("Faramnsh"));




	}
}
