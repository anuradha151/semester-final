package lk.anuradha.car.controller;

import lk.anuradha.car.dto.ItemDTO;
import lk.anuradha.car.exception.CustomException;
import lk.anuradha.car.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody ItemDTO itemDTO) {
        try {
            return itemService.save(itemDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save item. Operation unsuccessful");
        }
    }
}
