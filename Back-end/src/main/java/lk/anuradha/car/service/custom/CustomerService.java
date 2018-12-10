package lk.anuradha.car.service.custom;

import lk.anuradha.car.dto.CustomerDTO;
import lk.anuradha.car.model.Customer;
import lk.anuradha.car.service.CrudService;

public interface CustomerService extends CrudService<CustomerDTO, Customer> {

    Customer findByName(String name);

    Customer findByEmail(String email);

}
