package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by derekgilwa on 6/20/14.
 */
public class BibliotecaApp {

    private CommandMenu commandMenu;
    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream, CommandMenu commandMenu){
        this.printStream = printStream;
        this.commandMenu = commandMenu;
    }

    public void start() throws IOException {
        commandMenu.displayWelcome();
        commandMenu.listOptions();

        String userCommand = commandMenu.promptUser();
        int command = commandMenu.processUserCommand(userCommand);
        while(command == 0){
            printStream.println("Invalid Option. Please re-enter a number option.");
            userCommand = commandMenu.promptUser();
            command = commandMenu.processUserCommand(userCommand);
        }
        commandMenu.executeCommand(command);
    }
}
