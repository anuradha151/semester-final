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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public ResponseEntity<?> saveCustomer(CustomerDTO customerDTO) throws Exception {
        if (customerDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find customer details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        // create new customer entity to call repository
        Customer customer = new Customer();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNic());
        customer.setPassport(customerDTO.getPassport());

        // call customer repository
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
    public ResponseEntity<?> updateCustomer(CustomerDTO customerDTO) throws Exception {
        if (customerDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find customer details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
        Customer customer = byId.get();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNic());
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
    public ResponseEntity<?> findById(long id) throws Exception {
        Optional<Customer> byId = customerRepository.findById(id);

        if (byId.isPresent()) {
            CustomerDTO customerDTO = entityToDTO(byId.get());

            return new ResponseEntity<>(customerDTO, HttpStatus.OK);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "Customer details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> findAllCustomers() throws Exception {

        List<Customer> all = customerRepository.findAll();

        if (all.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "Customer details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        List<CustomerDTO> customerDTOS = new ArrayList<>();

        for (Customer customer : all) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setName(customer.getName());
            customerDTO.setNic(customer.getNIC());
            customerDTO.setPassport(customer.getPassport());

            customerDTOS.add(customerDTO);
        }

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> findByName(String name) {

        Optional<Customer> byName = customerRepository.findByName(name);

        if (!byName.isPresent()) {
            return new ResponseEntity<>("No customer is available for the specified name", HttpStatus.NOT_FOUND);
        }

        CustomerDTO customerDTO = entityToDTO(byName.get());

        return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);

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
}
