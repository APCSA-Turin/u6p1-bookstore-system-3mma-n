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

    public void removeUser(User user){
        User[] temp = users;
        users = new User[temp.length - 1];
        int idx = 0;
        while (temp[idx] != user) {
            users[idx] = temp[idx];
            idx++;
        }

        for (int i = idx; i < users.length; i++) {
            users[i] = temp[i + 1];
        }
    }

    public void consolidateUsers(){}

    public void addBook(Book book){}

    public void insertBook(Book book, int index){}

    public void removeBook(Book book){}
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}