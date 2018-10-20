package lk.anuradha.car.repository;

import lk.anuradha.car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
