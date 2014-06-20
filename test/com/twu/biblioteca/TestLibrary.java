package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by brandonteng on 6/20/14.
 */
public class TestLibrary {

    @Test
    public void shouldFormatAndPrintBookList(){
        PrintStream printStream = mock(PrintStream.class);
        Book b1 = new Book("title1", "author1", 2000);
        Book b2 = new Book("title2", "author2", 2001);
        int longestTitle = b1.getTitle().length()+4;
        int longestAuthor = b1.getAuthor().length()+4;
        List<Book> listOfBooks = new ArrayList<Book>(Arrays.asList(b1, b2));
        Library library = new Library(printStream, listOfBooks);

        library.formatAndPrint();
        String format = "%-" + longestTitle + "s" + "%-" + longestAuthor + "s" + "%s\n";

        verify(printStream).printf(format, "title1", "author1", 2000);
        verify(printStream).printf(format, "title2", "author2", 2001);
    }


}
