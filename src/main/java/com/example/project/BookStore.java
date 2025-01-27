package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users;

    // requires 1 empty constructor
    public BookStore() {
        users = new User[10];
        books = new Book[0];
    }

    // returns the list of users
    public User[] getUsers(){
        return users;
    }

    // sets the list of users
    public void setUsers(User[] u){
        users = u;
    }

    // returns the list of books
    public Book[] getBooks(){
        return books;
    }

    // adds a user to the end of the user list
    public void addUser(User user){
        // iterates through the user list to find the first null value
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                // adds the user and breaks the loop
                users[i] = user;
                break;
            }
        }
    } 

    // removes a user from the user list
    public void removeUser(User user){
        // iterates through the user list to find the user to be removed
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                // removes the user and breaks the loop
                users[i] = null;
                break;
            }
        }
        consolidateUsers();
        
    }

    // moves all users (that aren't null values) to the front of the user list
    public void consolidateUsers(){
        int idx = 0;
        // iterates through each item in the user list
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                // moves the non-null value to the next empty slot in the list (if it isn't already in the correct slot)
                if (i != idx) {
                    users[idx] = users[i];
                    users[i] = null;
                }
                // increments for every non-null value in the list found
                idx++;
            }
        }
    }
    // adds a book to the book list
    public void addBook(Book book){
        // creates a temporary copy of the book list
        Book[] temp = books;
        // sets the book list to a new blank list with a length 1 higher
        books = new Book[temp.length + 1];
        // fills in values of the temporary copy into the new book list
        for (int i = 0; i < temp.length; i++) {
            books[i] = temp[i];
        }
        // sets the final (still blank) value in the new book list to the added book
        books[books.length - 1] = book;
    }

    public void insertBook(Book book, int index){
        // creates a temporary copy of the book list
        Book[] temp = books;
        // sets the book list to a new blank list with a length 1 higher
        books = new Book[temp.length + 1];
        // fills in values of the temporary copy (before index) into the new book list
        for (int i = 0; i < index; i++) {
            books[i] = temp[i];
        }
        // adds the specified book to the correct index
        books[index] = book;
        // fills in values of the temporary copy (after index) into the new book list
        for (int i = index; i < temp.length; i++) {
            books[i + 1] = temp[i];
        }

    }

    // removes a book from the book list
    public void removeBook(Book book){
        // if the book has at least 2 copies left, 1 copy is removed
        if (book.getQuantity() > 1) {
            book.setQuantity(book.getQuantity() - 1);
        // if the book has only one copy left, it must be removed from the list
        } else {
            // creates a temporary copy of the book list
            Book[] temp = books;
            // sets the book list to a new blank list with a length 1 lower
            books = new Book[temp.length - 1];
            // fills in values of the temporary copy (before the book to be removed) into the new book list
            int idx = 0;
            while (temp[idx] != book) {
                books[idx] = temp[idx];
                idx++;
            }
            // fills in values of the temporary copy (after the book that will be removed) into the new book list
            for (int i = idx; i < books.length; i++) {
                books[i] = temp[i + 1];
            }
        }
    }
       
    public String bookStoreBookInfo(){
        String str = "";
        for (Book book : books) {
            str += "\n";
            if (book == null) {
                str += "empty";
            } else {
                str += book.bookInfo();
            }
        }
        return str;
    }

    public String bookStoreUserInfo(){
        String str = "Users:";
        for (User user : users) {
            str += ("\n------------------------");
            if (user == null) {
                str += "\nempty";
            } else {
                str += "\n" + user.userInfo();
            }
        }
        return str;
    }

    // returns a book based on title or ISBN (null if the book isn't found) (ADDED FUNCTION)
    public Book findBook(String str) {
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getTitle().equals(str) || book.getIsbn().equals(str)) {
                return book;
            }
        }
        return null;
    }

    // returns the index of book in bookList (ADDED FUNCTION)
    public int bookIndex(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == book) {
                return i;
            }
        }
        return -1;
    }
}