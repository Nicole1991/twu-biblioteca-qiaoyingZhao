package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.BookEntity;
import com.twu.biblioteca.model.OperationBookMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiaoying Zhao on 2017/2/24.
 */
public class BookService {
    private static BookService bookService = null;

    /**
     * book lists
     */
    private static List<BookEntity> bookList= new ArrayList<BookEntity>();

    /**
     * checkout book lists
     */
    private static List<BookEntity> checkoutBookList = new ArrayList<BookEntity>();

    private BookService() {
        init();
    }


    private void init() {
        bookList.add(new BookEntity(1, "Life of Pi", "Castelli", "2014"));
        bookList.add(new BookEntity(2,"Fellowship of the Ring","J.R.R.Tolkien","2012"));
        bookList.add(new BookEntity(3,"The Pragmatic Programmer","Andrew Hunt","2005"));
        bookList.add(new BookEntity(4,"Refactoring","Martin Fowler","2010"));
        bookList.add(new BookEntity(5,"Head First Java","Refactoring","2008"));
    }

    public static BookService getInstance(){
        if (bookService == null){
            bookService = new BookService();
        }
        return bookService;
    }

    public List<BookEntity> getBookList(){
        return bookList;
    }

    public String getBookListStr(){
        StringBuffer str = new StringBuffer();
        for (BookEntity existBookList:bookList){
            str.append("id: "+ existBookList.getId() + "\tBook name： "+ existBookList.getBookName()+"\r");
        }
        return str.toString();
    }

    /**
     *
     * @param id
     * @param name
     * @return bookEntity
     * According the id or name which given to get a book
     */
    private BookEntity getBook(Integer id, String name) {
        if (id == null && name == null)
            return null;
        Integer inputId;
        String inputName;
        inputId = id == null ? 0 : id;
        inputName = name == null ? "" : name;
        for (BookEntity book : bookList)
            if (inputId.equals(book.getId()) || inputName.equals(book.getBookName()))
                return book;
        return null;
    }

    public BookEntity getBook(Integer id) {
        return getBook(id, null);
    }

    public BookEntity getBook(String name) {
        return getBook(null, name);
    }

    /**
     * checkoutBook
     * @param inputId
     * @param inputBookName
     * @return
     */
    private OperationBookMessage checkoutBook(Integer inputId,String inputBookName) {
        String failMsg = "That book is not available.";
        String successMsg = "Thank you! Enjoy the book";

        if (inputId < 1 && inputBookName == null)
            return new OperationBookMessage(false, failMsg);
        inputId = inputId == null ? 0 : inputId;
        inputBookName = inputBookName == null ? "" : inputBookName;

        BookEntity checkoutBook = null;
        for (BookEntity book:bookList){
            if (inputId == book.getId() || inputBookName.equals(book.getBookName())) {
                checkoutBook = book;
                break;
            }
        }
        if (checkoutBook == null)
            return new OperationBookMessage(false,failMsg);

        bookList.remove(checkoutBook);
        checkoutBookList.add(checkoutBook);

        return new OperationBookMessage(true,successMsg);
    }

    public OperationBookMessage checkoutBook(Integer id){
        return checkoutBook(id,null);
    }

    public OperationBookMessage checkoutBook(String bookName){
        return checkoutBook(null,bookName);
    }

    /**
     * return book
     * @param inputId
     * @param inputBookName
     * @return
     */
    private OperationBookMessage returnBook(Integer inputId,String inputBookName) {
        String failMsg = "That is not a valid book to return";
        String successMsg = "Thank you for returning the book.";

        if (inputId < 1 && inputBookName == null)
            return new OperationBookMessage(false, failMsg);
        inputId = inputId == null ? 0 : inputId;
        inputBookName = inputBookName == null ? "" : inputBookName;

        BookEntity checkoutBook = null;
        for (BookEntity book:bookList){
            if (inputId == book.getId() || inputBookName.equals(book.getBookName())) {
                checkoutBook = book;
                break;
            }
        }
        if (checkoutBook == null)
            return new OperationBookMessage(false,failMsg);

        checkoutBookList.remove(checkoutBook);
        bookList.add(checkoutBook);

        return new OperationBookMessage(true,successMsg);
    }

    public OperationBookMessage returnBook(Integer id){
        return returnBook(id,null);
    }

    public OperationBookMessage returnBook(String bookName) {
        return returnBook(null,bookName);
    }
}
