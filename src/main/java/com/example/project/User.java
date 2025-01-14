package com.example.project;

public class User{
    // the name of the user
    private String name;
    // the ID of the user
    private String Id;
    // The list of books held by the user
    private Book[] books;

    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String n, String id) {
        name = n;
        Id = id;
        books = null;
    }

    // returns the user's name
    public String getName() {
        return name;
    }

    // sets the user's name to a new value
    public void setName(String n) {
        name = n;
    }

    // returns the user's ID
    public String getId() {
        return Id;
    }

    // sets the user's ID to a new value
    public void setId(String id) {
        Id = id;
    }

    // returns user's list of held books
    public Book[] getBooks() {
        return books;
    }

    // sets the user's list of held books
    public void setBooks(Book[] b) {
        books = b;
    }
    // Returns a list of details of each book for the user (empty forany items in the list that are null)
    /* Format:
    [First Book]
    [Second Book]
    ...
     */
    public String bookListInfo(){
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

    // Returns The user's name, ID, and a list of info about the books they've checked out.
    /* Format:
    Name: []
    ID: []
    Books:
    [First Book]
    [Second Book]
    ...
    */
    public String userInfo(){
        return "Name: " + name + "\nID: " + Id + "\nBooks:\n" + bookListInfo();
    }
       
}