package service;

import model.Developer;

public interface DeveloperService extends Service<Developer> {
    Developer get(String name);
}
