package com.twu.biblioteca.viewpage;

import com.twu.biblioteca.service.BookService;

/**
 * Created by Qiaoying Zhao on 2017/2/25.
 */
public class View {

    public static void printPrompt(String prompt){
        System.out.println(prompt);
    }

    public static void welcomePage(){
        View.printPrompt("************Welcome to the System--Biblioteca!!!************");
        View.printPrompt("****************************************");
        View.printPrompt("Please Enter your userName:");
    }

    public static void printBookList(){
        BookService bookService = BookService.getInstance();
        String bookString = bookService.getBookListStr();
        String[] bookList = bookString.split("\r");
        for (String book:bookList) {
            printPrompt(book);
        }
    }

}
