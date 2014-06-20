package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Book> bookList = new ArrayList<Book>();`
        bookList.add(new Book("Harry Potter And The Prisoner of Azkaban", "JK Rowling", 1999));
        bookList.add(new Book("The Shining", "Steven King", 1980));

        Library library = new Library(System.out, bookList);

        HashMap<Integer,Command> commands = new HashMap<Integer, Command>();
        Command listBooksCommand = new ListBooksCommand(library);
        commands.put(1, listBooksCommand);

        CommandMenu menu = new CommandMenu(System.out, new BufferedReader(new InputStreamReader(System.in)), commands);

        BibliotecaApp bibiliotecaApp = new BibliotecaApp(System.out, menu);
        bibiliotecaApp.start();

  }

}
