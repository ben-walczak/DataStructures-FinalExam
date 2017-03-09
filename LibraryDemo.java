package FinalExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Benjamin
 * given a set of data from multiple text files
 * construct data structures to hold the information within the text files
 * then use those data structures to find the books owned by a given card number from the user
 */
public class LibraryDemo {

	private static Map<String, Borrowers> borrowerMap;
	private static ArrayList<BookLoan> bookLoanArrayList;
	private static Map<String, Books> booksMap;
	
	public static void main(String[] args) {
		try {
			// create scanners for documents
			Scanner inBorrowers = new Scanner(new File("borrowers.txt"));
			Scanner inBookLoan = new Scanner(new File("book-loan.txt"));
			Scanner inBooks = new Scanner(new File("books.txt"));
			
			// instantiate maps
			borrowerMap = new HashMap<String, Borrowers>();
			bookLoanArrayList = new ArrayList<BookLoan>();
			booksMap = new HashMap<String, Books>();
			
			// declare temporary Employee and Department
			Borrowers tempBorrower;
			BookLoan tempBookLoan;
			Books tempBook;
			
			// temporary array to hold strings
			String Array[];
			
			// cycle through each given set of data and create an appropriate corresponding 
			// data structure to hold the information
			inBorrowers.nextLine();
			while(inBorrowers.hasNextLine()) {
				Array = inBorrowers.nextLine().split(",");
				tempBorrower = new Borrowers(Array[0],Array[1]);
				borrowerMap.put(Array[0], tempBorrower);
			}
			inBookLoan.nextLine();
			while(inBookLoan.hasNextLine()) {
				Array = inBookLoan.nextLine().split(",");
				tempBookLoan = new BookLoan(Array[0],Array[1],Array[2],Array[3]);
				bookLoanArrayList.add(tempBookLoan);
			}
			inBooks.nextLine();
			while(inBooks.hasNextLine()) {
				Array = inBooks.nextLine().split(",");
				tempBook = new Books(Array[0],Array[1],Array[2]);
				booksMap.put(Array[0], tempBook);
			}
			
			// signal user the data was successfully read
			System.out.println("--reading books.txt, borrowers.txt, and book-loan.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: One or more of the files could not be found.");
			System.exit(0);
		}
		
		// display all books that are in the possession of the given card number
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter a borrowers card number:");
		String cardNumber = kb.next();
		if(borrowerMap.containsKey(cardNumber)) {
			System.out.println("Books borrowed by "+cardNumber+"("
					+borrowerMap.get(cardNumber).getName()
					+") are as follows:");
			for(int i = 0; i < bookLoanArrayList.size(); i++) {
				if(bookLoanArrayList.get(i).getCardNumber().equals(cardNumber)) {
					System.out.println(booksMap.get(bookLoanArrayList.get(i).getBookID()).getTitle()
							+", due date: "+bookLoanArrayList.get(i).getDueDate());
				}
			}
		}
		
		// if the given card number does not match any card numbers within the data structure
		else {
			System.out.println("Sorry the card number you have entered does not exist.");
		}
		
	}
}
