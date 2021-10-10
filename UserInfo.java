import java.util.Scanner;

public class UserInfo {
	
	public String getName(String name) {
		BookInfo t = new BookInfo();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Greetings, welcome to Simply Books!");
		System.out.println("Please let us get to know more about you.");
		
		String sentile;
		
		do {
			System.out.print("Name: ");
			name = input.next();
			System.out.println(name + ", right? (y/n)");
			sentile = input.next();
			sentile = sentile.toLowerCase();
		} while(!sentile.equals("y"));
		
		return name;
	}
	
}
