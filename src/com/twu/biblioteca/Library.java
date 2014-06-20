package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richiethomas on 6/17/14.
 */
public class Library {

    private PrintStream printStream;
    private List<Book> listOfBooks;

    public Library(PrintStream printStream, List<Book> listOfBooks) {
        this.printStream = printStream;
        this.listOfBooks = listOfBooks;
    }

    //PUT LIST OF BOOKS IN MAIN
    //PASS THROUGH LIBRARY
    //test -> format -> print
    //change hashmap ->

    public void display() {
        printStream.println(this.formatAndPrint());
    }


    public String formatAndPrint() {
        final int padding = 4;
        final int longestTitle = returnLongestTitle() + padding;
        final int longestAuthor = returnLongestAuthor() + padding;

        String format = "%-" + longestTitle + "s" + "%-" + longestAuthor + "s" + "%s\n";

        String result = "";
        for (Book book : listOfBooks) {
            //printStream.printf(format, book.getTitle(), book.getAuthor(), book.getYear());
            result += String.format(format, book.getTitle(), book.getAuthor(), book.getYear());
        }
        return result;
    }

    private int returnLongestTitle(){
        List<String> titles = new ArrayList<String>();
        for (Book book : listOfBooks) {
            titles.add(book.getTitle());
        }
        StringLengthFinder lengthFinder = new StringLengthFinder();
        return lengthFinder.findMaxStringLength(titles);
    }

    private int returnLongestAuthor(){
        List<String> authors = new ArrayList<String>();
        for (Book book : listOfBooks) {
            authors.add(book.getAuthor());
        }
        StringLengthFinder lengthFinder = new StringLengthFinder();
        return lengthFinder.findMaxStringLength(authors);
    }

}
