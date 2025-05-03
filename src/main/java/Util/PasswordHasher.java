package Util;
public class PasswordHasher {
	    public static void main(String[] args) {
	        String password = "admin1234"; // 🔑 This is the password you want to hash
	        String hashed = PasswordUtil.hashPassword(password);
	        System.out.println("Hashed admin password: " + hashed);
	    }
}
