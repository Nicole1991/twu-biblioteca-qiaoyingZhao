package com.twu.biblioteca.servicetest;

import com.twu.biblioteca.entity.BookEntity;
import com.twu.biblioteca.service.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiaoying Zhao on 2017/2/24.
 */
public class BookServiceTest {
    @Before
    public void setUp() throws Exception {
        BookService bookService = BookService.getInstance();
        List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
    }

    /**
     * Method: getBookList()
     */
    @Test
    public void testGetBookList() throws Exception {
    }

    /**
     * Method: getBookListStr()
     */
    @Test
    public void testGetBookListStr() throws Exception {
    }

    /**
     * Method: getBook(Integer id)
     */
    @Test
    public void testGetBookId() throws Exception {
    }

    /**
     * Method: getBook(String name)
     */
    @Test
    public void testGetBookName() throws Exception {
    }

    /**
     * Method: checkoutBook(Integer id)
     */
    @Test
    public void testCheckoutBookId() throws Exception {

    }

    /**
     * Method: checkoutBook(String bookName)
     */
    @Test
    public void testCheckoutBookBookName() throws Exception {
    }

    /**
     * Method: returnBook(Integer id)
     */
    @Test
    public void testReturnBookId() throws Exception {
    }

    /**
     * Method: returnBook(String bookName)
     */
    @Test
    public void testReturnBookBookName() throws Exception {
    }


    /**
     * Method: init()
     */
    @Test
    public void testInit() throws Exception {

    }

    /**
     * Method: getBook(Integer id, String name)
     */
    @Test
    public void testGetBookIsOk() throws Exception {

    }

    /**
     * Method: checkoutBook(Integer inputId, String inputBookName)
     */
    @Test
    public void testCheckoutBook() throws Exception {
    }

    /**
     * Method: returnBook(Integer inputId, String inputBookName)
     */
    @Test
    public void testReturnBook() throws Exception {

    }
}
