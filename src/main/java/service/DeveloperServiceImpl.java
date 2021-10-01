package service;

import model.Developer;
import repository.Repository;

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
}
