package lk.anuradha.car.service.impl;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.model.Customer;
import lk.anuradha.car.model.ResponseModel;
import lk.anuradha.car.repository.CustomerRepository;
import lk.anuradha.car.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public ResponseEntity<?> saveCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find customer details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNIC());
        customer.setPassport(customerDTO.getPassport());

        Customer save = customerRepository.save(customer);

        if (save != null) {
            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "Customer saved successfully", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Customer saving failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> updateCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find customer details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
        Customer customer = byId.get();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNIC());
        customer.setPassport(customerDTO.getPassport());

        Customer save = customerRepository.save(customer);

        if (save != null) {
            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "Customer successfully updated", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Customer updating failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

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
