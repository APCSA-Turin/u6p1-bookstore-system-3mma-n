package com.example.project;
import java.util.Scanner;
public class Runner {
    // clears the terminal (learned here: https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java)
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // displays the books in "shelves" in rows of 5
    private static void display(BookStore store) {
        // determines the necessary number of rows
        int rows = (store.getBooks().length + 5 - 1) / 5;
        System.out.println("------------------------------------");
        // iterates through each row
        for (int i = 0; i < rows; i++) {
            // iterates through each column
            for (int j = 0; j < 5; j++) {
                if (i * 5 + j >= store.getBooks().length) {
                    // prints an empty shelf if the length of books is greater than the current index
                    System.out.print("|      ");
                } else {
                    Book book = store.getBooks()[i * 5 + j];
                    // prints a shortened version of the book's title (using a call to shorten()) and its quantity
                    System.out.print("|" + shorten(book.getTitle()) + " " + book.getQuantity() + "");
                }
            }
            System.out.println("|");
            System.out.println("------------------------------------");
        }
        // System.out.println(store.getUsers()[0]);
    }

    // returns a 4 letter version of a string
    private static String shorten(String str) {
        // adds spaces to the string if its length is < 4
        if (str.length() < 4) {
            for (int i = str.length(); i < 4; i++) {
                str += " ";
            }
            return str;
        }

        int spaceCount = 0;
        // iterates through characters in the string to count the # of spaces
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals(" ")) {
                spaceCount++;
                // if 3 spaces have been found, the loop ends (and further words will be ignored)
                if (spaceCount == 3) {
                    break;
                }
            }
        }
        // creates a new string with a # of characters from the first word (1-4) depending on the counted # of spaces
        String newStr = str.substring(0, 4 - spaceCount);
        // adds the first letter of each following word (up to 3 more words max) to the new string
        for (int i = 0; i < spaceCount; i++) {
            str = str.substring(str.indexOf(" ") + 1);
            newStr += str.substring(0, 1);
        }
        // returns the final string
        return newStr;
    }

    // prompts the user to repeat the same action or select a different choice from the menu (returning their answer)
    public static boolean userContinues(Scanner sc) {
        System.out.println("\nPress 1 to repeat action.");
        System.out.println("Press 0 to return to menu.");
        System.out.print("Enter Selection: ");
        // returns true for 1, false for 0
        if (sc.nextInt() == 1) {
            sc.nextLine();
            return true;
        }
        sc.nextLine();
        return false;
    }

    // returns a book based on title or ISBN
    public static Book findBook(BookStore store, String str) {
        for (Book current : store.getBooks()) {
            // checks each book to see if its title or ISBN match the inputted string
            if (str.equals(current.getTitle()) || str.equals(current.getIsbn())) {
                return current;
            }
        }
        // returns null if no match is found
        return null;
    }

    // returns a user based on name or ID
    public static User findUser(BookStore store, String str) {
        for (User current : store.getUsers()) {
            // checks each user to see if its name or ID matches the inputted string
            if (!(current == null) && (str.equals(current.getName()) || str.equals(current.getId()))) {
                return current;
            }
        }
        // returns null if no match is found
        return null;
    }

    public static void main(String[] args) {
        // creates a variable to track the user's selections in the menu
        int input = 0;

        Scanner sc = new Scanner(System.in);
        BookStore store = new BookStore();

        // adds 5 starting books to the library
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        clear();
        display(store);

        while (input != -1) {
            // prints out the features of the interface that the user can choose between
            System.out.println("1) Add Book");
            System.out.println("2) Check Out Book");
            System.out.println("3) Insert Book");
            System.out.println("4) Search for a Book");
            System.out.println("5) Register New Student");
            System.out.println("6) Check Student Registration");
            System.out.println("7) Upgrade Book Quantity");
            System.out.println("-1) Quit");

            // reads the user's selection and sets the input variable accordingly
            System.out.print("Enter Choice: ");
            input = sc.nextInt();
            sc.nextLine();
            
            if (input == 1) {
                /* when the variable stay is created and used with a while loop for each feature, 
                 * it is used to track whether the user will continue with the same feature or return to the menu
                */
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Add Book");
                    // the user is prompted to enter details for the new book
                    System.out.println("Please enter book details below: ");
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year Published: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    // creates and adds a new book to the end of the list based on user input
                    store.addBook(new Book(title, author, year, isbn, quantity));
                    clear();
                    display(store);
                    // prints a message confirming the addition of the new book
                    System.out.println(quantity + " copies of '" + title + "' by " + author + " have been added at row " + 
                    (store.getBooks().length / 5 + 1) + ", column " + (store.getBooks().length % 5) + ".");

                    stay = userContinues(sc);
                }
            } else if (input == 2) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Check Out Book");
                    // prompts the user to identify a book to remove
                    System.out.print("Enter Title or ISBN: ");
                    String str = sc.nextLine();
                    Book book = findBook(store, str);
                    // checks whether the book was found in the list.
                    if (book != null) {
                        // if so, one copy of the book is removed
                        int q = book.getQuantity();
                        store.removeBook(book);
                        clear();
                        display(store);
                        // prints a message confirming the removal of the book and the # of copies remaining
                        System.out.println("Removing 1 copy of '" + book.getTitle() + "' from supply.");
                        System.out.println("There are now " + (q - 1) + " copies left.");
                    } else {
                        System.out.println("Error: Unable to locate book with this Title or ISBN.");
                    }
                    stay = userContinues(sc);
                }
            } else if (input == 3) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Insert Book");
                    // prompts the user to provide a row and column (at which to insert a new book)
                    System.out.println("Select a row and column below to insert a new book.");
                    System.out.print("Row: ");
                    int row = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Column: ");
                    int col = sc.nextInt();
                    sc.nextLine();
                    // calculates what index in the book list the rows and columns would refer to
                    int idx = (row - 1) * 5 + (col - 1);
                    // checks if this index is valid
                    if (idx >= 0 && idx < store.getBooks().length) {
                        // the following features are the same as the 'Add Book' option
                        System.out.println("Please enter book details below: ");
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Year Published: ");
                        int year = sc.nextInt();
                        sc.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        store.insertBook(new Book(title, author, year, isbn, quantity), idx);
                        clear();
                        display(store);
                        System.out.println(quantity + " copies of '" + title + "' by " + author + " have been inserted at row " + row + ", column " + col + ".");
                        System.out.println("The locations of other books have been shifted to accommodate this change.");
                    } else {
                        // prints an error message if the selected row and column are invalid
                        System.out.println("Error: A shelf at row " + row + ", column " + col + " does not exist.");
                    }
                    stay = userContinues(sc);
                }
            } else if (input == 4) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Search for a Book");
                    // prompts the user to provide the title or ISBN of the book to be searched for
                    System.out.print("Enter Title or ISBN: ");
                    String str = sc.nextLine();
                    // calls findBook() to attempt to locate the book
                    Book book = findBook(store, str);
                    if (book != null) {
                        // prints information about the book if found
                        int idx = store.bookIndex(book);
                        System.out.println("Book found at row " + (idx / 5 + 1) + ", column " + (idx % 5 + 1) + ".");
                        System.out.println(book.bookInfo());
                    } else {
                        // if no matching book is found, this message is displayed
                        System.out.println("A Book with this title or ISBN has not been added.");
                    }
                    stay = userContinues(sc);
                    
                }
            } else if (input == 5) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Register New Student");
                    // guarantees that the number of students cannot surpass 10
                    if (!IdGenerate.getCurrentId().equals("109")) {
                        // prompts the user to enter the name of the student to be added
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        // increments the current ID by 1 (to create a new ID)
                        IdGenerate.generateID();
                        // creates and adds a new User with the inputted name and the next ID
                        store.addUser(new User(name, IdGenerate.getCurrentId()));
                        clear();
                        display(store);
                        // displays output message confirming the addition of the new student
                        System.out.println(name + " has now been registered and assigned ID number " + IdGenerate.getCurrentId() + ".");

                    } else {
                        // displays an error message if the max number of students has been reached
                        System.out.println("Error: 10 students already registered. No more can be added.");
                    }
                    stay = userContinues(sc);
                }
            } else if (input == 6) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Check Student Registration");
                    // prompts the user to enter a student to search for
                    System.out.print("Enter Student Name or ID: ");
                    String str = sc.nextLine();
                    // attempts to find a student with the provided name or ID
                    User student = findUser(store, str);
                    if (student != null) {
                        // displays the student's information if a matching student is found
                        System.out.println("This student is registered! Displaying available information: ");
                        System.out.print(student.userInfo());
                    } else {
                        // if no matching student is found, a message is displayed accordingly
                        System.out.println("A student with this name or ID has not yet been registered.");
                    }
                    stay = userContinues(sc);
                }
            } else if (input == 7) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Upgrade Book Quantity");
                    // prompts the user to select a book to add to
                    System.out.print("Enter Title or ISBN: ");
                    String str = sc.nextLine();
                    // confirms that this book is actually in the list
                    Book book = findBook(store, str);
                    if (book != null) {
                        // prompts the user to pick a number of copies to add
                        System.out.print("Enter Quantity to Add: ");
                        int added = sc.nextInt();
                        sc.nextLine();
                        if (added > 0) {
                            // adds the provided number to the quantity attribute of the provided book
                            book.setQuantity(book.getQuantity() + added);
                            clear();
                            display(store);
                            // displays a message confirming the addition of copies to the provided book
                            System.out.println("Quantity of '" + book.getTitle() + "' is now " + book.getQuantity() + " copies.");
                        } else {
                            // displays an error if the user enters a non-positive # when asked how many copies to add
                            System.out.println("Error: Must add a positive number of copies.");
                        }
                    } else {
                        // displays an error if no valid book is found
                        System.out.println("Error: Unable to locate book with this Title or ISBN.");
                    }
                    stay = userContinues(sc);
                }
            }

            clear();
            display(store);
        }
        sc.close();
    }
}