package bai2;

public class userDAO {
	public static boolean Authentication(String username,String password) {
		if("anh".equals(username)&& "12345".equals(password)) {
			return true;}
		
		else {
			return false;
		}
	}

}
