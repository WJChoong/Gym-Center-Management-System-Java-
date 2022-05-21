package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Auth {
    public static User login(String username, String password) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(Auth.class.getClassLoader().getResourceAsStream("user.txt")));
    	String data = null;
    	User user = new User();
    	Boolean status = false;
    	while((data=reader.readLine()) != null) {
    		String[] rawData = data.split(",") ;
    		if (rawData[1].equals(username) &&  rawData[2].equals(password)) {
    			status = true;
    			user.setId(rawData[0]);
    			user.setName(rawData[4]);
    			user.setPosition(rawData[3]);
    			user.setAge(rawData[5]);
    			user.setGender(rawData[6]);
    			user.setCountry(rawData[7]);
    			user.setPassword(rawData[2]);
    			user.setUsername(rawData[1]);
    			break;
    		}
    	}
    	reader.close();
        return user;
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
