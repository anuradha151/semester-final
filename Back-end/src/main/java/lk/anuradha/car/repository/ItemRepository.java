package lk.anuradha.car.repository;

import lk.anuradha.car.model.car_models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
