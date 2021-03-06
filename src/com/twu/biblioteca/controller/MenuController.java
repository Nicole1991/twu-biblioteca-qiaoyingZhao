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

    BookService bookService = BookService.getInstance();
    MovieService movieService = MovieService.getInstance();
    BookEntity bookEntity = null;
    MovieEntity movieEntity = null;
    OperationMessage optMsg = new OperationMessage();

    public void menuControl(boolean flag) {
        String str;
        int grade = 0;

        Integer id = 0;
        while (flag) {
            switch (grade) {
                case 0://first level of the menu
                    View.printPrompt("Please enter the function what you need!");
                    View.printPrompt("1:Book List;2:Checkout Book;3:Return Book;4:Movie List;" +
                            "5:Checkout Movie;9:Exit System;0:Return the main menu;");
                    str = getInputInformationFromKeyboard();
                    grade = getSelectedMenuLevel(str);
                    break;
                case 1://Book List
                    View.printPrompt("Book List");
                    View.printBookList();
                    View.printPrompt("Please Enter Id or Name Which Book You Want Check!");
                    str = getInputInformationFromKeyboard();
                    showBookDetails(str);
                    grade = 0;
                    break;

                case 2://checkout book
                    View.printPrompt("Please enter the book which you want to checkout!");
                    str = getInputInformationFromKeyboard();
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
                    str = getInputInformationFromKeyboard();
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
                    str = getInputInformationFromKeyboard();
                    showMovieDetails(str);
                    grade = 0;
                    break;

                case 5://checkout movie
                    View.printPrompt("Please enter the book which you want to checkout!");
                    str = getInputInformationFromKeyboard();
                    id = 0;
                    try {
                        id = Integer.parseInt(str);
                    } catch (Exception e) {
                    }
                    optMsg = null;
                    if (id > 0) {
                        optMsg = movieService.checkoutMovie(id);
                    } else {
                        optMsg = movieService.checkoutMovie(str);
                    }
                    View.printPrompt(optMsg.getErrorMessage());
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

    public void showBookDetails(String inputInformation) {
        int id = 0;
        try {
            id = Integer.parseInt(inputInformation);
        } catch (Exception e) {
        }
        bookEntity = null;
        if (id > 0) {
            bookEntity = bookService.getBook(id);
        } else {
            bookEntity = bookService.getBook(inputInformation);
        }
        if (bookEntity == null)
            View.printPrompt("The title you entered does not exist！");
        else {
            System.out.println(bookEntity);
        }
    }

    public void showMovieDetails(String inputInformation) {
        Integer id = 0;
        try {
            id = Integer.parseInt(inputInformation);
        } catch (Exception e) {
        }
        movieEntity = null;
        if (id > 0) {
            movieEntity = movieService.getMovie(id);
        } else {
            movieEntity = movieService.getMovie(inputInformation);
        }
        if (movieEntity == null)
            View.printPrompt("The title you entered does not exist！");
        else {
            System.out.println(movieEntity);
        }
    }

    public int getSelectedMenuLevel(String inputStr) {
        int grade;
        if (inputStr.equals("Book List") || inputStr.equals("1")) {
            grade = 1;
        } else if (inputStr.equals("Checkout Book") || inputStr.equals("2")) {
            grade = 2;
        } else if (inputStr.equals("Return Book") || inputStr.equals("3")) {
            grade = 3;
        } else if (inputStr.equals("Movie List:") || inputStr.equals("4")) {
            grade = 4;
        } else if (inputStr.equals("Checkout Movie") || inputStr.equals("5")) {
            grade = 5;
        } else if (inputStr.equals("Exit System!") || inputStr.equals("9")){
            grade = 9;
        } else if (inputStr.equals("Return the main menu") || inputStr.equals("0")) {
            grade = 0;
        } else {
            View.printPrompt("Error Input！");
            grade = 0;
        }
        /*switch (inputStr) {
            case "1":
            case "Book List":
                grade = 1;
                break;
            case "2":
            case "Checkout Book":
                grade = 2;
                break;
            case "3":
            case "Return Book":
                grade = 3;
                break;
            case "4":
            case "Movie List":
                grade = 4;
                break;
            case "5":
            case "Checkout Movie":
                grade = 5;
                break;
            case "0":
            case "Return the Main Menu":
                grade = 0;
                break;
            default:
                View.printPrompt("Error Input！");
                grade = 0;
        }*/
        return grade;
    }

    public String getInputInformationFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().trim();
        return str;
    }
}
