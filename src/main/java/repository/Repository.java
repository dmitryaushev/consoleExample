package repository;

import model.BaseEntity;

import java.util.List;

public interface Repository<T extends BaseEntity> {

    void create(T t);

    void update(T t);

    void delete(int id);

    T get(int id);

    List<T> getAll();
}
