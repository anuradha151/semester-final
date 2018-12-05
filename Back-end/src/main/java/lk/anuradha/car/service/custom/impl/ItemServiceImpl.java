package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.ItemDTO;
import lk.anuradha.car.service.custom.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public ResponseEntity<?> save(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(long code) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }
}
