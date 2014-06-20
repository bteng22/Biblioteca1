package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by richiethomas on 6/17/14.
 */
public class TestCommandMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private CommandMenu commandMenu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
    }

    @Test
    public void testWelcomeMessage() {
        commandMenu = new CommandMenu(printStream, reader,mock(HashMap.class));
        commandMenu.displayWelcome();
        verify(printStream).println("Welcome to the library!");
    }

    @Test
    public void shouldListAllMenuOptions() {
        HashMap<Integer, Command> commands = new HashMap<Integer, Command>();
        Command command = mock(Command.class);
        commands.put(1, command);
        commandMenu = new CommandMenu(printStream, reader, commands);

        commandMenu.listOptions();
        verify(printStream).println("list");
    }

    @Test
    public void shouldAcceptAndExecuteCommand() throws IOException {
        HashMap<Integer, Command> commands = new HashMap<Integer, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put(-1, command);
        when(reader.readLine()).thenReturn("zzzz");

        String userCommand = commandMenu.promptUser();
        commandMenu.processUserCommand(userCommand);
        verify(command).execute();
    }

    @Test
    public void shouldDisplayBookList() throws IOException {
        HashMap<Integer, Command> commands = new HashMap<Integer, Command>();
        List<Book> listOfBooks = new ArrayList<Book>();
        commandMenu = new CommandMenu(mock(PrintStream.class), reader, commands);
        Command command = new ListBooksCommand(new Library(printStream, listOfBooks));
        commands.put(1,command);
        when(reader.readLine()).thenReturn("list");

        String userCommand = commandMenu.promptUser();
        commandMenu.processUserCommand(userCommand);
        verify(printStream).println("Harry Potter And The Prisoner of Azkaban|  JK Rowling                              |  1999\n" +
                "The Shining                             |  Steven King                             |  1980\n");
    }

    @Test
    public void shouldReturnZeroWhenInvalid() throws IOException {
        HashMap<Integer, Command> commands = new HashMap<Integer, Command>();
        commandMenu = new CommandMenu(printStream, reader, commands);
        Command command = mock(Command.class);
        commands.put(-1, command);
        when(reader.readLine()).thenReturn("Invalid option");

        String userCommand = commandMenu.promptUser();
        int inputCommand = commandMenu.processUserCommand(userCommand);
        assertThat(inputCommand, is(0));
    }
    
    
}
