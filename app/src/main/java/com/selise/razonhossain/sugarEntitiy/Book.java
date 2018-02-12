package com.selise.razonhossain.sugarEntitiy;

import com.orm.SugarRecord;


/**
 * Created by razon.hossain on 2/6/2018.
 */


public class Book extends SugarRecord {

    public Book(){}

    String name;
    String releaseDate;
    String price;
    String bookID;
    Author author;

    public Book(String name, String releaseDate, String price, String id, Author author) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.price = price;
        this.bookID = id;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
