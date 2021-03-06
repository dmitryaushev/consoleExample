package controller;

import exception.ExitException;
import repository.DeveloperRepositoryImpl;
import service.DeveloperServiceImpl;
import util.InputString;
import util.View;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class MainController {

    private View view;
    private List<Command> commands;

    public MainController(View view, DataSource dataSource) {
        this.view = view;
        DeveloperServiceImpl developerService = new DeveloperServiceImpl(new DeveloperRepositoryImpl(dataSource));
        this.commands = Arrays.asList(
                new CreateDeveloper(view, developerService),
                new Exit(view)
        );
    }

    public void read() {
        view.write("Hello");
        view.write("Enter a command:");
        try {
            doCommand();
        } catch (ExitException e) {

        }
    }

    private void doCommand() {
        while (true) {
            InputString entry = new InputString(view.read());
            for (Command command : commands) {
                try {
                    if (command.canProcess(entry)) {
                        entry.validateParameters(command.command());
                        command.process(entry);
                        break;
                    }
                } catch (Exception e) {
                    if (e instanceof ExitException) {
                        throw e;
                    }
                    printError(e);
                    break;
                }
            }
        }
    }

    private void printError(Exception e) {
        String message = e.getMessage();
        view.write("Error because of " + message);
        view.write("Please try again");
    }
}
