package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    
// MY OWN TESTS
    
    String patronTest1 = "John Smith";
    if (lib1.checkout(9780330351690L, patronTest1, 1, 1, 2008))
        System.err.println("TEST FAILED: third checkout");
    
    if (lib1.checkin(patronTest1))
        System.err.println("TEST FAILED: checkin(holder)");

    
    
    
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");
    
    
    if(booksCheckedOut1.contains(new Book(948488222690L, "Jon Krakauer",
            "Into the Wild"))){
    	System.err.print("Test Failed");
    }

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");
    


    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
   
    
    
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    
    
    System.out.println("Testing done.");
    
    // FILL IN for tests
    
    //I added in some code above to test with the original code
       
    PhoneNumber patronTest2 = new PhoneNumber("305.469.2812");
    
    if (!lib2.checkout(9780446580342L, patronTest2, 1, 1, 2008))
        System.err.println("TEST FAILED: third checkout 2");
    
    if (!lib2.checkin(patronTest2))                           
        System.err.println("TEST FAILED: checkin(holder) 2");
    
    // FOR LAB: write tests for getInventoryList
    
/*    
    Library<PhoneNumber> lib4 = new Library<PhoneNumber>();
    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib4.add(9780446580342L, "David Baldacci", "Simple Genius");
    lib4.add(9780446580209L, "Brandon Sanderson", "Mistborn");
    lib4.add(9780146580347L, "Rick Riordan", "Percy Jackson");
    lib4.add(9780446580339L, "Brandon Sanderson", "The Way of Kings");
    
    ArrayList<LibraryBook<PhoneNumber>> isbnOrdered = lib4.getInventoryList();
    
    for(int index = 0; index<isbnOrdered.size(); index++) {
    	System.out.println(isbnOrdered.get(index));
    }
    System.out.println();
    
 // Testing method of order by Author
    
    ArrayList<LibraryBook<PhoneNumber>> authorOrdered = lib4.getOrderedByAuthor();    
    for(int index = 0; index<authorOrdered.size(); index++) {
    	System.out.println(authorOrdered.get(index));
    }
    */
    
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    //Test ISBN ORDERED:
    ArrayList<LibraryBook<String>> isbnOrderedLib3 = lib3.getInventoryList();
    
    for(int index = 0; index<isbnOrderedLib3.size(); index++) {
    	System.out.println(isbnOrderedLib3.get(index));
    }
    System.out.println();
    
    //Test AUTHOR ORDERED
    
    ArrayList<LibraryBook<String>> authorOrderedLib3 = lib3.getOrderedByAuthor();
    
    for(int index = 0; index<authorOrderedLib3.size(); index++) {
    	System.out.println(authorOrderedLib3.get(index));
    }
    System.out.println();
    
    //Checkout Books
    String name1 = "Joe Smith";
    String name2 = "Ally Jones";
    String name3 = "Doug Smith";
    
    lib3.checkout(9781843190769L, name1, 1, 12, 2021);
    lib3.checkout(9781843190400L, name2, 2, 12, 2021);
    lib3.checkout(9781843190028L, name1, 3, 11, 2021);
    lib3.checkout(9781843191230L, name3, 2, 21, 2021);
    lib3.checkout(9781843190479L, name2, 2, 20, 2021);
    
    //TEST ORDER BY DUE DATE
    
    ArrayList<LibraryBook<String>> dueDateOrdered = lib3.getOverdueList(2, 21, 2021);
    
    for(int index = 0; index< dueDateOrdered.size(); index++) {
    	System.out.println(dueDateOrdered.get(index));
    }
    
  }
}
