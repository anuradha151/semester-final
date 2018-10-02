package lk.anuradha.car.service;

import lk.anuradha.car.dto.ItemDTO;
import org.springframework.http.ResponseEntity;

public interface ItemService {

    ResponseEntity<?> save(ItemDTO itemDTO) throws Exception;

    ResponseEntity<?> update(ItemDTO itemDTO) throws Exception;

    ResponseEntity<?> delete(ItemDTO itemDTO) throws Exception;

    ResponseEntity<?> findById(long code) throws Exception;

    ResponseEntity<?> getAll() throws Exception;

}
