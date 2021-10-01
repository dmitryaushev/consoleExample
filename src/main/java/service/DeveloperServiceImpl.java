package service;

import model.Developer;
import model.Gender;
import repository.Repository;
import util.InputString;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService{

    private Repository repository;

    public DeveloperServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Developer get(String name) {
        return null;
    }

    @Override
    public Developer get(int id) {
        return null;
    }

    @Override
    public void create(Developer developer) {
        repository.create(developer);
    }

    @Override
    public void update(Developer developer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Developer> getAll() {
        return null;
    }
    
    public Developer mapDeveloper(InputString input) {
        String[] parameters = input.getParameters();

        String name = parameters[1];
        int age = Integer.parseInt(parameters[2]);
        Gender gender = Gender.valueOf(parameters[3]);

        Developer developer = new Developer();
        developer.setName(name);
        developer.setAge(age);
        developer.setGender(gender);

        return developer;
    }
}
