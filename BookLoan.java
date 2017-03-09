package FinalExam;

public class BookLoan {
private String bookID;
private String cardNumber;
private String dateOut;
private String dueDate;
	public BookLoan(String bookID, String cardNumber, String dateOut, String dueDate) {
		this.bookID = bookID;
		this.cardNumber = cardNumber;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
	}
	public String getBookID() {
		return bookID;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getDueDate() {
		return dueDate;
	}
}
