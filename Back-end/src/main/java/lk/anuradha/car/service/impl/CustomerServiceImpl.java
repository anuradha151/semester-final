package lk.anuradha.car.service.impl;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public ResponseEntity<?> saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findCustomer(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAllCustomers() {
        return null;
    }
}
