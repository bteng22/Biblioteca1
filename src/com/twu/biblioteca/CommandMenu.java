package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

/**
 * Created by derekgilwa on 6/18/14.
 */
public class CommandMenu {
    private HashMap<Integer, Command> commands;
    private PrintStream printStream;
    private BufferedReader reader;

    public CommandMenu(PrintStream printStream, BufferedReader reader, HashMap<Integer, Command> commands) {
        this.printStream = printStream;
        this.reader = reader;
        this.commands = commands;
    }


    public void listOptions() {
        for (Command command : commands.values()) {
            printStream.println(command.getCommandString());
        }
    }

    public String promptUser() throws IOException {
        return reader.readLine();
    }

    public int processUserCommand(String command) {
        int input = 0;
        try {
            int value = Integer.parseInt(command);
            if (commands.keySet().contains(value)) {
                input = value;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
        return input;
    }

    public void executeCommand(int command){commands.get(command).execute();}

    public void displayWelcome() {
        printStream.println("Welcome to the library!");
    }
}
