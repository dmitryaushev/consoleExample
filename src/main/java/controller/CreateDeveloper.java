package controller;

import model.Developer;
import service.DeveloperServiceImpl;
import util.Commands;
import util.InputString;
import util.View;

public class CreateDeveloper implements Command{

    private View view;
    private DeveloperServiceImpl service;

    public CreateDeveloper(View view, DeveloperServiceImpl service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public String command() {
        return Commands.CREATE_DEVELOPER;
    }

    @Override
    public void process(InputString input) {
        Developer developer = service.mapDeveloper(input);
        service.create(developer);
        view.write(String.format("Developer created with name - %s", developer.getName()));
    }
}
