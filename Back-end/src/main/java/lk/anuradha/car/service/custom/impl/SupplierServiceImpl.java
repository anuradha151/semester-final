package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.SupplierDTO;
import lk.anuradha.car.model.ResponseModel;
import lk.anuradha.car.model.Supplier;
import lk.anuradha.car.repository.SupplierRepository;
import lk.anuradha.car.service.custom.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private ResponseModel responseModel = new ResponseModel();


    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @Override
    public ResponseEntity<?> save(SupplierDTO supplierDTO) {
        Supplier save = supplierRepository.save(dTOtoEntity(supplierDTO));
        if (save == null) {

            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Supplier not saved.", false), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseModel(HttpStatus.OK.value(), "Supplier saved successfully.", true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(SupplierDTO supplierDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(SupplierDTO supplierDTO) {
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

    private Supplier dTOtoEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setContactNumber(supplierDTO.getContactNumber());
        supplier.setAddress(supplierDTO.getAddress());
        return supplier;

    }
}
