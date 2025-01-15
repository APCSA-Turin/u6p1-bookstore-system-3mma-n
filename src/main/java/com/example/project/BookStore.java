package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
    private User[] users;

    // requires 1 empty constructor
    public BookStore() {}

    public User[] getUsers(){
        return users;
    }

    public void setUsers(User[] u){
        users = u;
    }

    public Book[] getBooks(){
        return books;
    }

    // adds a user to the end of the user list
    public void addUser(User user){
        // creates a temporary copy of the current user list
        User[] temp = users;
        // sets the user list to a new blank list with a length 1 higher
        users = new User[temp.length + 1];
        // fills in value of the temporary copy into the new user list
        for (int i = 0; i < temp.length; i++) {
            users[i] = temp[i];
        }
        // sets the final (still blank) value in the new user list to the added user
        users[users.length - 1] = user;
    } 

    // removes a user from the user list
    public void removeUser(User user){
        // creates a temporary copy of the current user list
        User[] temp = users;
        // sets the user list to a new blank list with a length 1 lower
        users = new User[temp.length - 1];
        // fills in values of the temporary copy (before the user to be removed) into the new user list
        int idx = 0;
        while (temp[idx] != user) {
            users[idx] = temp[idx];
            idx++;
        }
        // fills in values of the temporary copy (after the user that will be removed) into the new user list
        for (int i = idx; i < users.length; i++) {
            users[i] = temp[i + 1];
        }
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

    public void insertBook(Book book, int index){}

    // removes a book from the book list
    public void removeBook(Book book){
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
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}