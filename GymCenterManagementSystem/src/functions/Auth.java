package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Auth {
    public boolean login(String username, String password) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("user.txt")));
    	String data = null;
    	Boolean status = false;
    	while((data=reader.readLine()) != null) {
    		System.out.println(data);
    		String[] rawData = data.split(",") ;
    		if (rawData[1].equals(username) &&  rawData[2].equals(password)) {
    			status = true;
    			break;
    		}
    	}
    	reader.close();
        return status;
    }

    public boolean resetPassword(String username, String newPassword, String confirmPassword) {
        return true;
    }

    public boolean changePassword(String username, String newPassword, String confirmPassword) {
        return true;
    }

    public boolean register() throws IOException {
//    	BufferedReader reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("user.txt")));
//    	String data = null;
//		while((data=reader.readLine()) != null) {}
//		BufferedWriter buffer = new BufferedWriter(reader);  
//	    buffer.write("Welcome to javaTpoint.");  
////		String[] details = data.split(":");
//		reader.close();
		
        return true;
    }
}
