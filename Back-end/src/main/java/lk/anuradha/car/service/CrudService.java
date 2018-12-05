package lk.anuradha.car.service;

import org.springframework.http.ResponseEntity;

public interface CrudService<T> {

    ResponseEntity<?> save(T t);

    ResponseEntity<?> update(T t);

    ResponseEntity<?> delete(T t);

    ResponseEntity<?> findById(T t);

    ResponseEntity<?> findAll(T t);

}
