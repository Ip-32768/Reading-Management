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
			System.out.println(completionData[i]);
		}
		
		Scanner input = new Scanner(System.in);
		
		int TotalPages;
		int CurrentPage;
		double CompletionPercentage;
		
		System.out.print("Total Pages: ");
		TotalPages = input.nextInt();
		
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
}
