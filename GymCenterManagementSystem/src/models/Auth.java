package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
    public static void register(String username, String password, String position, String name, String age, String gender, String country) throws IOException {
        String filename = "src\\user.txt";
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        // Read lines from the file until no more are left.
        int num = 0;
        while (inputFile.hasNext())
        {
            // Read the next line.
            String data = inputFile.nextLine();
            
            // Split the line by using the delimiter ":" (semicolon) and store into array.
            String[] details = data.split(",");
            int ID = removeCharacter(details[0], "US");
            if (ID > num){
                num = ID;
            }
        }   
        inputFile.close(); // Close the file
        FileWriter fw = new FileWriter(filename, true);
        PrintWriter outputFile = new PrintWriter(fw);
        num ++;
        String num_ID = String.valueOf(num);
        String ID = "0";
        if (num_ID.length() < 5){
            for (int i = 0; i < (4-num_ID.length()); i++){
                String halfID = "0";
                ID = ID + halfID;
            }
            ID = "US"+ ID + num_ID;
        }
        else{
            ID = "US" + num;
        }
        String data = ID + "," + username + "," + password + "," + position + "," + name + "," + age + "," + gender + "," + country;
        outputFile.println(data);
        outputFile.close();
		
    }
    
    public static int removeCharacter(String str, String character) {
    	return Integer.parseInt(str.replace(character, ""));
    }
    
    public static void removeRecord(String filepath, String removeTerm) throws IOException{
        String tempFile = "src/temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String currentLine;
        String data[];
        FileWriter fw = new FileWriter(tempFile,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        while ((currentLine = br.readLine()) != null){
            data = currentLine.split(",");
            if (!(data[0].equals(removeTerm))){
            	System.out.println(data[0] + " - " + removeTerm);
                pw.println(currentLine);
            }
        }

        pw.flush();
        pw.close();
        fr.close();
        br.close();
        bw.close();
        fw.close();

        oldFile.delete();
        File dump = new File(filepath);
        newFile.renameTo(dump);
    }
}
