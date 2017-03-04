package com.twu.biblioteca;

import com.twu.biblioteca.controller.LoginController;
import com.twu.biblioteca.controller.MenuController;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.entity.BookEntity;
import com.twu.biblioteca.model.OperationMessage;
import com.twu.biblioteca.viewpage.View;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        View.welcomePage();
        LoginController login = new LoginController();
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        View.printPrompt("please Enter your password:");
        String password = scan.next();
        boolean flag = login.login(userName,password);

        MenuController menu = new MenuController();
        menu.menuControl(flag);
    }

}
