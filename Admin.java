public class Admin {

	String username;
	String password;

	public Admin() {
		username = "SYSTEM";
		password = "123";
	}

	public boolean validateAdmin(String u, String p) {
		if (u.equals(username) && p.equals(password)) {
			return true;
		}
		return false;
	}
}
