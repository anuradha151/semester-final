package lk.anuradha.car.service;

import java.util.List;

public interface CrudService<T> {

    T save(T t);

    T update(T t);

    void delete(T t);

    T findById(long id);

    List<T> findAll();

}
