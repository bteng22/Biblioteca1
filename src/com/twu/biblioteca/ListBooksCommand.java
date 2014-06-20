package com.twu.biblioteca;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class ListBooksCommand implements Command {
    private Library library;

    public ListBooksCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        library.display();
    }

    @Override
    public String getCommandString() {
        return "1. List all books";
    }
}
