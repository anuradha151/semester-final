package lk.anuradha.car.repository;

import lk.anuradha.car.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c WHERE c.name=:name")
    Optional<Customer> findByName(@Param("name") String name);

    @Query(value = "SELECT c FROM Customer c WHERE c.email=:email")
    Optional<Customer> findByMail(@Param("email") String email);

}
