package com.example.project;

public class Book{
    
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // constructor initializes each of the 5 instance variables
    public Book(String t, String a, int y, String i, int q) {
        title = t;
        author = a;
        yearPublished = y;
        isbn = i;
        quantity = q;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int y) {
        yearPublished = y;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String i) {
        isbn = i;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    // Returns information stored in the book's instance variables by appending each to a new String
    // Format: "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
    public String bookInfo(){
        String str = "";
        str += "Title: " + title + ", ";
        str += "Author: " + author + ", ";
        str += "Year: " + yearPublished + ", ";
        str += "ISBN: " + isbn + ", ";
        str += "Quantity: " + quantity;
        return str;
    }
       
}