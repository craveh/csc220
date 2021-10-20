package lab03;

// What imports do you need to include? Put them here.
import java.util.GregorianCalendar;

public class LibraryBook extends Book {
	
	String holder;
	GregorianCalendar dueDate;

	// A LibraryBook contains a holder (a String) and due date represented by
	// a GregorianCalendar
	
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
		
	}

	public String getHolder() {
		
		return(this.holder);
		// FILL IN
		//return null; // placeholder
	}
	
	public GregorianCalendar getDueDate() {
		return(dueDate);
	}
	
	public void checkin() {
		holder = null;
		dueDate = null;
				
	}
	
	public void checkout(String holder, GregorianCalendar dueDate){
		this.holder = holder;
		this.dueDate = dueDate;
	}	

	// Do not override the equals method in Book

}