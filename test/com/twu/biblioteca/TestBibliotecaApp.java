package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class TestBibliotecaApp {
    private CommandMenu commandMenu;
    private PrintStream printStream;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp(){
        commandMenu = mock(CommandMenu.class);
        printStream = mock(PrintStream.class);
        bibliotecaApp = new BibliotecaApp(printStream, commandMenu);
    }

    @Test
    public void testBibliotecaAppStartCallsWelcomeAndMenu() throws IOException {
        when(commandMenu.promptUser()).thenReturn("1");
        when(commandMenu.processUserCommand("1")).thenReturn(1);

        bibliotecaApp.start();

        verify(commandMenu).displayWelcome();
        verify(commandMenu).listOptions();
        verify(commandMenu).promptUser();
        verify(commandMenu).processUserCommand("1");
    }

    @Test
    public void shouldDisplayInvalidOptionMessage() throws IOException {
        when(commandMenu.promptUser()).thenReturn("100").thenReturn("1");
        when(commandMenu.processUserCommand("100")).thenReturn(0);
        when(commandMenu.processUserCommand("1")).thenReturn(1);

        bibliotecaApp.start();
        verify(printStream).println("Invalid Option. Please re-enter a number option.");
    }


}
