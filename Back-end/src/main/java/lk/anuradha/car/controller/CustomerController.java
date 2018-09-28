package lk.anuradha.car.controller;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.exception.CustomException;
import lk.anuradha.car.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public ResponseEntity<?> saveCustomer(CustomerDTO customerDTO) {
        try {
            return customerService.saveCustomer(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save user. Operation unsuccessful");
        }
    }

    public ResponseEntity<?> updateCustomer(CustomerDTO customerDTO) {
        try {
            return customerService.updateCustomer(customerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save user. Operation unsuccessful");
        }
    }

    public ResponseEntity<?> findById(long id) {
        try {
            return customerService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch customer. Operation unsuccessful");
        }
    }

    public ResponseEntity<?> findAllCustomers(){
        try {
            return customerService.findAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch customer details. Operation unsuccessful");
        }
    }


}
