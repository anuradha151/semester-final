package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.SupplierDTO;
import lk.anuradha.car.service.custom.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Override
    public ResponseEntity<?> save(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }
}
