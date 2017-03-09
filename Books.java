package FinalExam;

public class Books {
	private String bookID;
	private String title;
	private String publisher;
	public Books(String bookID, String title, String publisher) {
		this.bookID = bookID;
		this.title = title;
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
}
