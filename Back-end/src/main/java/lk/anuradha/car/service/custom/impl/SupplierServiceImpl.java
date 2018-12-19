package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.SupplierDTO;
import lk.anuradha.car.model.Supplier;
import lk.anuradha.car.repository.SupplierRepository;
import lk.anuradha.car.service.custom.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public ResponseEntity<?> save(SupplierDTO supplierDTO) {
        if (supplierDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Supplier save = supplierRepository.save(dTOToEntity(supplierDTO));
        if (save == null) {
            return new ResponseEntity<>("Supplier saving failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Supplier saved", HttpStatus.OK);
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

    private Supplier dTOToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setContactNumber(supplierDTO.getContactNumber());
        return supplier;
    }

    private SupplierDTO entityToDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setContactNumber(supplier.getContactNumber());
        return supplierDTO;
    }
}
