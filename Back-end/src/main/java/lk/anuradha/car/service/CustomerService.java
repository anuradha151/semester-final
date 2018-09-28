package lk.anuradha.car.service;

import lk.anuradha.car.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> saveCustomer(CustomerDTO customerDTO);

    ResponseEntity<?> updateCustomer(CustomerDTO customerDTO);

    ResponseEntity<?> findById(long id);

    ResponseEntity<?> findAllCustomers();

}
