import java.util.Scanner;

public class SimplyRead {
	String decision;
	
	static String username;
	static String[] book_titles = { };
	static String[] book_authors = { };
	static double[]book_PercentageCompletion = { };
	
	public static void main(String args[]) {
		
		SimplyRead SimplyReadObj = new SimplyRead();
		SimplyReadObj.Menu();
		
	}
	
	public void Menu() {
		
		UserInfo userData = new UserInfo();
		SimplyRead SimplyReadObj = new SimplyRead();
		BookInfo libraryData = new BookInfo();
		
		username = userData.getName(username);
		
		Scanner input = new Scanner(System.in);
		
		int bookDeletionChoice = -1;
		String userMenuChoice;
		
		do {
			
			System.out.println("Menu");
			System.out.println("[1] - Check Collection");
			System.out.println("[2] - Add to Collection");
			System.out.println("[3] - Update Readings");
			System.out.println("[4] - Delete Element");
			System.out.println("[q] - Quit");
			userMenuChoice = input.next();
			if(userMenuChoice.equals("1")) {
				SimplyReadObj.DisplayCollection();
			} else if(userMenuChoice.equals("2")) {
				book_titles = libraryData.findBookData_TA(book_titles, "t");
				book_authors = libraryData.findBookData_TA(book_authors, "a");
				book_PercentageCompletion = libraryData.findCompletionPercentage(book_PercentageCompletion);
			} else if(userMenuChoice.equals("3")) {
				book_PercentageCompletion = libraryData.UpdatePercentage(book_PercentageCompletion, book_titles);
			} else if(userMenuChoice.equals("4")) {
				bookDeletionChoice = libraryData.getElement(bookDeletionChoice, book_titles);
				if(bookDeletionChoice != -1) {
					book_titles = libraryData.deleteStringElement(book_titles, bookDeletionChoice);
					book_authors = libraryData.deleteStringElement(book_authors, bookDeletionChoice);
					book_PercentageCompletion = libraryData.deleteDoubleElement(book_PercentageCompletion, bookDeletionChoice);
				}
			} else if(userMenuChoice.equals("Q")) {
				userMenuChoice.toLowerCase();
			}
		} while(!userMenuChoice.equals("q"));
		
		System.out.println("Thank you");
	}
	
	public void DisplayCollection() {
		UserInfo userData = new UserInfo();
		
		System.out.println(username + "'s Collection");
		
		for(int i = 0; i < book_titles.length; i++) {
			System.out.println(book_titles[i] + " - " + book_authors[i]);
			System.out.printf("[%.0f%s]\n", book_PercentageCompletion[i], "%");
		}
		
		if(book_titles.length == 0) {
			System.out.println("-Empty-");
		}
	}
	
}
