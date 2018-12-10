package lk.anuradha.car.service;

import java.util.List;

public interface CrudService<T, R> {

    R save(T t);

    R update(T t);

    void delete(T t);

    R findById(long id);

    List<R> findAll();

}
