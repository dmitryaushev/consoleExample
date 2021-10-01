package controller;

import exception.ExitException;
import util.Commands;
import util.InputString;
import util.View;

public class Exit implements Command{

    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public String command() {
        return Commands.EXIT;
    }

    @Override
    public void process(InputString input) {
        view.write("Good bye");
        throw new ExitException("Exit");
    }
}
