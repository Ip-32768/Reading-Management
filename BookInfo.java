import java.util.Scanner;

public class BookInfo {
	
	public String[]findBookData_TA(String[]bookData, String type) {
		
		//New Array - Array Space + 1
		String[] moreWords = new String[bookData.length+1];
		
		//copy contents
		for(int i = 0; i < bookData.length; i++) {
			moreWords[i] = bookData[i];
		}
		
		Scanner input = new Scanner(System.in);
		
		String sentinel;
		
		
		if(type.equals("t")) {
			System.out.println("[Book]");
			System.out.print("Title: ");
		} else if(type.equals("a")) {
			System.out.print("Author: ");
		}
		
		moreWords[moreWords.length-1] = input.nextLine();
			
		
		return moreWords;
	}
	
	public double[]findCompletionPercentage(double[]bookData) {
		
		//New Array - Array Space + 1
		double[] completionData = new double[bookData.length+1];
		
		//copy contents
		for(int i = 0; i < bookData.length; i++) {
			completionData[i] = bookData[i];
		}
		
		Scanner input = new Scanner(System.in);
		
		int TotalPages;
		int CurrentPage;
		double CompletionPercentage;
		
		do {
			System.out.print("Total Pages: ");
			TotalPages = input.nextInt();
			if(TotalPages < 1) {
				System.out.println("-Invalid Input-");
				System.out.println("-Total Pages cannot be below 1");
			}
		} while(TotalPages < 1);
		
		do {
			System.out.print("Current Page: ");
			CurrentPage = input.nextInt();
			
			if(CurrentPage > TotalPages) {
				System.out.println("-Invalid Input-");
				System.out.println("-Current Page cannot pass Total Pages-");
			} else if(CurrentPage < 0) {
				System.out.println("-Invalid Input-");
				System.out.println("-Current Pages cannot be below Zero-");
			}
		} while(CurrentPage > TotalPages || CurrentPage < 0);
		
		CompletionPercentage = ((double)CurrentPage/(double)TotalPages) * 100.00;
		
		completionData[completionData.length-1] = CompletionPercentage;
		
		return completionData;
	}
	
	public double[] UpdatePercentage(double percentage[], String bookTitles[]) {
		if(bookTitles.length < 1) {
			System.out.println("-Collection Empty-");
			return percentage;
		}
		Scanner input = new Scanner(System.in);
		int bookChoice;
		
		//Selection of which book to update percentage
		System.out.println("[Update]");
		System.out.println("Current Collection");
		for(int i = 0; i < bookTitles.length; i++) {
			System.out.println("[" + (i+1) + "] " + bookTitles[i]);
		}
		
		System.out.println("Update Book: ");
		bookChoice = input.nextInt()-1;
		
		//Page Updates
		int TotalPages;
		int CurrentPage;
		double readingPercentage;
		
		do {
			System.out.print("Total Pages: ");
			TotalPages = input.nextInt();
			if(TotalPages < 1) {
				System.out.println("-Invalid Input-");
				System.out.println("-Total Pages cannot be below 1");
			}
		} while(TotalPages < 1);
		
		do {
			System.out.print("Current Page: ");
			CurrentPage = input.nextInt();
			
			if(CurrentPage > TotalPages) {
				System.out.println("-Invalid Input-");
				System.out.println("-Current Page cannot pass Total Pages-");
			} else if(CurrentPage < 0) {
				System.out.println("-Invalid Input-");
				System.out.println("-Current Pages cannot be below Zero-");
			}
		} while(CurrentPage > TotalPages || CurrentPage < 0);
		
		readingPercentage = ((double)CurrentPage / (double)TotalPages) * 100;
		
		percentage[bookChoice] = readingPercentage;
		
		return percentage;
	}
	
	public String[] deleteStringElement(String[] bookData, int bookChoice) {
		
		//New Array - Array Space - 1
		String[] completionData = new String[bookData.length-1];
			
		//copy contents
		for(int i = 0; i < bookData.length; i++) {
			if(i != bookChoice) {
				completionData[i] = bookData[i];
				System.out.println(completionData[i]);
			}
		}
		
		return completionData;
	}
	
	public double[] deleteDoubleElement(double[] percentageData, int bookChoice) {
		//New Array - Array Space - 1
		double[] completionData = new double[percentageData.length-1];
		
		//copy contents
		for(int i = 0; i < percentageData.length; i++) {
			if(i != bookChoice) {
				completionData[i] = percentageData[i];
			}
		}
		
		return completionData;
	}
	
	public int getElement(int elementSelection, String[] bookTitles) {
		if(bookTitles.length < 1) {
			System.out.println("-Collection Empty-");
			return -1;
		}
		
		Scanner input = new Scanner(System.in);
		int bookChoice;
		
		System.out.println("[Delete]");
		System.out.println("Current Collection");
		for(int i = 0; i < bookTitles.length; i++) {
			System.out.println("[" + (i+1) + "] " + bookTitles[i]);
		}
		
		System.out.println("Delete Book: ");
		bookChoice = input.nextInt()-1;
		
		return bookChoice;
	}
}
