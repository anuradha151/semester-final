package lk.anuradha.car.service.custom;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.model.Customer;
import lk.anuradha.car.service.CrudService;
import org.springframework.http.ResponseEntity;

public interface CustomerService extends CrudService<CustomerDTO, Customer> {

    ResponseEntity<?> findByName(String name);

    ResponseEntity<?> findByEmail(String email);

}
