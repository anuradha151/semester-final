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
    public Customer save(CustomerDTO customerDTO) {

        // create new customer entity to call repository
        Customer customer = new Customer();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNic());
        customer.setPassport(customerDTO.getPassport());

        // call customer repository
        return customerRepository.save(customer);

    }

    @Override
    public Customer update(CustomerDTO customerDTO) {

        Optional<Customer> byId = customerRepository.findById(customerDTO.getId());
        Customer customer = byId.get();
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setNIC(customerDTO.getNic());
        customer.setPassport(customerDTO.getPassport());

        // call update customer method in repository
        return customerRepository.save(customer);


    }

    @Override
    public void delete(CustomerDTO customerDTO) {

    }

    @Override
    public Customer findById(long id) {

        // call repository for find customer by id
        return customerRepository.findById(id).get();

    }

    @Override
    public List<Customer> findAll() {

        // get all customer list from the repository
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
    public Customer findByName(String name) {

        Optional<Customer> byName = customerRepository.findByName(name);

        if (!byName.isPresent()) {
            return new ResponseEntity<>("No customer is available for the specified name", HttpStatus.NOT_FOUND);
        }

        CustomerDTO customerDTO = entityToDTO(byName.get());

        return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);

    }

    @Override
    public Customer findByEmail(String email) {
        return null;
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
