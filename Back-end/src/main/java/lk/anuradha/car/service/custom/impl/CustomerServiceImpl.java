package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.model.Customer;
import lk.anuradha.car.model.ResponseModel;
import lk.anuradha.car.repository.CustomerRepository;
import lk.anuradha.car.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> save(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.NO_CONTENT.value(), "", false), HttpStatus.NO_CONTENT);
        }

        try {
            Customer save = customerRepository.save(dTOtoEntity(customerDTO));
            if (save != null) {
                return new ResponseEntity<>(new ResponseModel(HttpStatus.OK.value(), "Customer saved successfully", true), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Customer failed to save", false), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), e.getMessage() + "\nCustomer failed to save", false), HttpStatus.BAD_REQUEST);
        }


    }

    @Override
    public ResponseEntity<?> update(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.NO_CONTENT.value(), "", false), HttpStatus.NO_CONTENT);
        }
        try {
            Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
            if (!byId.isPresent()) {
                return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Cannot update details. Not a existing user", false), HttpStatus.BAD_REQUEST);
            }
            Customer customer = byId.get();
            customer.setAddress(customerDTO.getAddress());
            customer.setEmail(customerDTO.getEmail());
            customer.setName(customerDTO.getName());
            customer.setNIC(customerDTO.getNic());
            customer.setPassport(customerDTO.getPassport());


            Customer save = customerRepository.save(dTOtoEntity(customerDTO));
            if (save != null) {
                return new ResponseEntity<>(new ResponseModel(HttpStatus.OK.value(), "Customer updated successfully", true), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Customer failed to update", false), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), e.getMessage() + "\nCustomer failed to update", false), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> delete(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.NO_CONTENT.value(), "", false), HttpStatus.NO_CONTENT);
        }
        Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
        if (!byId.isPresent()) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Not a existing user", false), HttpStatus.BAD_REQUEST);
        }

        try {
            customerRepository.delete(byId.get());
            return new ResponseEntity<>(new ResponseModel(HttpStatus.OK.value(), "Customer removed successfully", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Customer failed to remove", false), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> findById(long id) {

        // call repository for find customer by id
        Optional<Customer> byId = customerRepository.findById(id);

        if (byId.isPresent()) {
            CustomerDTO customerDTO = entityToDTO(byId.get());
            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Customer details unavailable. ", false), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> findAll() {

        List<Customer> all = customerRepository.findAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>(new ResponseModel(HttpStatus.NOT_FOUND.value(), "Customer details unavailable. ", false), HttpStatus.NOT_FOUND);
        }
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : all) {
            customerDTOS.add(entityToDTO(customer));
        }
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> findByName(String name) {

        Optional<Customer> byName = customerRepository.findByName(name);
        if (!byName.isPresent()) {
            return new ResponseEntity<>("No customer is available for the specified name", HttpStatus.BAD_REQUEST);
        }
        CustomerDTO customerDTO = entityToDTO(byName.get());
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByEmail(String email) {
        Optional<Customer> byName = customerRepository.findByMail(email);
        if (!byName.isPresent()) {
            return new ResponseEntity<>("No customer is available for the specified mail", HttpStatus.NOT_FOUND);
        }
        CustomerDTO customerDTO =
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    private CustomerDTO entityToDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setNic(customer.getNIC());
        customerDTO.setPassport(customer.getPassport());

        return customerDTO;
    }

    private Customer dTOtoEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNic());
        customer.setPassport(customerDTO.getPassport());
        return customer;
    }


}
