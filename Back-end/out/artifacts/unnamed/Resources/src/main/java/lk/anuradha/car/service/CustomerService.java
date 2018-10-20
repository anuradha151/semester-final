package lk.anuradha.car.service;

import lk.anuradha.car.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    ResponseEntity<?> saveCustomer(CustomerDTO customerDTO) throws Exception;

    ResponseEntity<?> updateCustomer(CustomerDTO customerDTO) throws Exception;

    ResponseEntity<?> findById(long id) throws Exception;

    ResponseEntity<?> findAllCustomers() throws Exception;

}
