package com.twu.biblioteca.entity;

import java.awt.print.Book;

/**
 * Created by Qiaoying Zhao on 2017/2/24.
 */
public class BookEntity {

    private Integer id;
    private String bookName;
    private String author;
    private String yearPublished;

    public BookEntity(Integer id,String bookName,String author,String yearPublished) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Integer getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String toString(){
        return "Book{"+
                "id: " + id +
                ", name: '" + bookName + '\'' +
                ",author: '" + author + + '\'' +
                ",yearPublished: '" + yearPublished + '\'' +
                "}";
    }

}
