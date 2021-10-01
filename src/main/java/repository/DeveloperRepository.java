package repository;

import model.Developer;

public interface DeveloperRepository extends Repository<Developer> {
    Developer get(String name);
}
