package functions;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		Auth test = new Auth();
		String response = test.login("Alice Chin", "Chin89190h");
		System.out.print(response);		
	}
}
