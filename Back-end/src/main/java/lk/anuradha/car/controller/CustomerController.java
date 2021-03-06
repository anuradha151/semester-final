package lk.anuradha.car.controller;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.exception.CustomException;
import lk.anuradha.car.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/car/customer")
public class CustomerController {


    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        try {
            return customerService.save(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save user. Operation unsuccessful");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            return customerService.update(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save user. Operation unsuccessful");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        try {
            return customerService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch customer. Operation unsuccessful");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("find-by-name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return customerService.findByName(name);
    }


}
