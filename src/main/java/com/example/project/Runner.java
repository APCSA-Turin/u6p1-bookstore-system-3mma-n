package com.example.project;
import java.util.Scanner;
public class Runner {
    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void display(BookStore store) {
        int perRow = 5;
        int rows = (store.getBooks().length + perRow - 1) / perRow;

        for (int j = 0; j < perRow; j++) {
            System.out.print("-------");
        }
        System.out.println("-");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 5; j++) {
                if (i * perRow + j >= store.getBooks().length) {
                    System.out.print("|      ");
                } else {
                    Book book = store.getBooks()[i * perRow + j];
                    System.out.print("|" + shorten(book.getTitle()) + " " + book.getQuantity() + "");
                }
            }
            System.out.println("|");

            for (int j = 0; j < perRow; j++) {
                System.out.print("-------");
            }
            System.out.println("-");
        }
        // System.out.println(store.getUsers()[0]);
    }

    private static String shorten(String str) {
        if (str.length() < 4) {
            for (int i = str.length(); i < 4; i++) {
                str += " ";
            }
            return str;
        }
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i+1).equals(" ")) {
                spaceCount++;
                if (spaceCount == 3) {
                    break;
                }
            }
        }
        String newStr = str.substring(0, 4 - spaceCount);
        for (int i = 0; i < spaceCount; i++) {
            str = str.substring(str.indexOf(" ") + 1);
            newStr += str.substring(0, 1);
        }
        return newStr;
    }

    public static boolean userContinues(Scanner sc) {
        System.out.println("\nPress 1 to repeat action.");
        System.out.println("Press 0 to return to menu.");
        System.out.print("Enter Selection: ");
        if (sc.nextInt() == 1) {
            sc.nextLine();
            return true;
        }
        sc.nextLine();
        return false;
    }

    public static Book findBook(BookStore store, store)

    public static void main(String[] args) {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        BookStore store = new BookStore();
        
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);store.addBook(b2);store.addBook(b3);store.addBook(b4);store.addBook(b5);
        store.addBook(b2);
        clear();
        display(store);

        while (input != -1) {
            System.out.println("1) Add Book");
            System.out.println("2) Check Out Book");
            System.out.println("3) Return Book");
            System.out.println("4) Search for a Book");
            System.out.println("5) Register New Student");
            System.out.println("6) Check Student Registration");
            System.out.println("7) Upgrade Book Quantity");


            System.out.print("Enter Choice: ");
            input = sc.nextInt();
            sc.nextLine();
            
            if (input == 1) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Add Book");
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
                    store.addBook(new Book(title, author, year, isbn, quantity));
                    clear();
                    display(store);

                    System.out.println(quantity + " copies of '" + title + "' by " + author + " have been added at row " + 
                    (store.getBooks().length / 5 + 1) + ", column " + (store.getBooks().length % 5 + 1) + ".");

                    stay = userContinues(sc);
                }
            } else if (input == 2) {
                
            } else if (input == 3) {
                
            } else if (input == 4) {
                boolean stay = true;
                while (stay) {
                    clear();
                    display(store);
                    System.out.println("Selected: Search for a Book");
                    System.out.print("Enter Title or ISBN: ");
                    String str = sc.nextLine();
                    Book book = store.findBook(str);
                    if (book != null) {
                        int idx = store.bookIndex(book);
                        System.out.println("Book found at row " + (idx / 5 + 1) + ", column " + (idx % 5 + 1) + ".");
                        System.out.println(book.bookInfo());
                    } else {
                        System.out.println("Error: Unable to locate book with this Title or ISBN.");
                    }
                    stay = userContinues(sc);
                    
                }
            } else if (input == 5) {

            } else if (input == 6) {

            } else if (input == 7) {
                boolean stay = true;
                while (stay) {
                    System.out.println("Selected: Upgrade Book Quantity");
                    System.out.print();
                    stay = userContinues(sc);
                }
            }

            clear();
            display(store);
        }
        sc.close();
    }
}