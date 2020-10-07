package Classes;

public class Admin {
	private static String username = "A";
	private static String password = "123";
	
	public Admin() {
		this.username ="";
		this.password ="";
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Admin.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Admin.password = password;
	}
	 public static void main(String[] args) {
		
	 }

}