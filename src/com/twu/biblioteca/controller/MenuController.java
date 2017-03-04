package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.BookEntity;
import com.twu.biblioteca.entity.MovieEntity;
import com.twu.biblioteca.model.OperationMessage;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.viewpage.View;

import java.util.Scanner;

/**
 * Created by Qiaoying Zhao on 2017/2/25.
 */
public class MenuController {
    public void menuControl(boolean flag){
        String str;
        int grade = 0;
        BookService bookService = BookService.getInstance();
        MovieService movieService = MovieService.getInstance();
        BookEntity bookEntity = null;
        MovieEntity movieEntity = null;
        OperationMessage optMsg = new OperationMessage();
        Integer id = 0;
        while (flag){
            switch (grade){
                case 0://first level of the menu
                    View.printPrompt("Please enter the function what you need!");
                    View.printPrompt("1:Book List;2:Checkout Book;3:Return Book;4:Movie List;0:Return the main menu;");
                    Scanner sc = new Scanner(System.in);
                    str = sc.next();
                    if (str.equals("Book List") || str.equals("1")) {
                        grade = 1;
                    } else if (str.equals("Checkout Book") || str.equals("2")) {
                        grade = 2;
                    } else if (str.equals("Return Book") || str.equals("3")) {
                        grade = 3;
                    } else if (str.equals("Movie List") || str.equals("4")) {
                        grade = 4;
                    } else if (str.equals("Return the main menu") || str.equals("0")){
                        grade = 0;
                    }else {
                        View.printPrompt("Error Input！");
                        grade = 0;
                    }
                    break;
                case 1://Book List
                    View.printPrompt("Book List");
                    View.printBookList();
                    View.printPrompt("Please Enter Id or Name Which Book You Want Check!");
                    sc = new Scanner(System.in);
                    str = sc.next().trim();
                    id = 0;
                    try {
                        id = Integer.parseInt(str);
                    } catch (Exception e) {
                    }
                    bookEntity = null;
                    if (id > 0) {
                        bookEntity = bookService.getBook(id);
                    } else {
                        bookEntity = bookService.getBook(str);
                    }
                    if (bookEntity == null)
                        View.printPrompt("The title you entered does not exist！");
                    else {
                        System.out.println(bookEntity);
                    }
                    grade = 0;
                    break;

                case 2://checkout book
                    View.printPrompt("Please enter the book which you want to checkout!");
                    sc = new Scanner(System.in);
                    str = sc.next().trim();
                    id = 0;
                    try {
                        id = Integer.parseInt(str);
                    } catch (Exception e) {
                    }
                    optMsg = null;
                    if (id > 0) {
                        optMsg = bookService.checkoutBook(id);
                    } else {
                        optMsg = bookService.checkoutBook(str);
                    }
                    View.printPrompt(optMsg.getErrorMessage());
                    grade = 0;
                    break;

                case 3://Return book
                    View.printPrompt("Please enter the book which you want to return!");
                    sc = new Scanner(System.in);
                    str = sc.next().trim();
                    id = 0;
                    try {
                        id = Integer.parseInt(str);
                    } catch (Exception e) {
                    }
                    optMsg = null;
                    if (id > 0) {
                        optMsg = bookService.returnBook(id);
                    } else {
                        optMsg = bookService.returnBook(str);
                    }
                    View.printPrompt(optMsg.getErrorMessage());
                    grade = 0;
                    break;

                case 4://Movie List
                    View.printPrompt("Movie List:");
                    View.printMovieList();
                    View.printPrompt("Please Enter Id or Name Which Movie You Want Check!");
                    sc = new Scanner(System.in);
                    str = sc.next().trim();
                    id = 0;
                    try {
                        id = Integer.parseInt(str);
                    } catch (Exception e) {
                    }
                    movieEntity = null;
                    if (id > 0) {
                        movieEntity = movieService.getMovie(id);
                    } else {
                        movieEntity = movieService.getMovie(str);
                    }
                    if (movieEntity == null)
                        View.printPrompt("The title you entered does not exist！");
                    else {
                        System.out.println(movieEntity);
                    }
                    grade = 0;
                    break;

                case 9:
                    flag = false;
                    break;

                default:
                    View.printPrompt("select a valid option");
                    break;
            }
        }
    }
}
