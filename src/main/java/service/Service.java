package service;

import model.BaseEntity;

import java.util.List;

public interface Service<T extends BaseEntity> {

    void create(T t);

    void update(T t);

    void delete(int id);

    T get(int id);

    List<T> getAll();
}
