package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.ItemDTO;
import lk.anuradha.car.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public ResponseEntity<?> save(ItemDTO itemDTO) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> update(ItemDTO itemDTO) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(ItemDTO itemDTO) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(long code) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() throws Exception {
        return null;
    }
}
