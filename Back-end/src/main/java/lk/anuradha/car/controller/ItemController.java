package lk.anuradha.car.controller;

import lk.anuradha.car.dto.ItemDTO;
import lk.anuradha.car.exception.CustomException;
import lk.anuradha.car.service.custom.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody ItemDTO itemDTO) {


        try {
            return itemService.save(itemDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to Save item. Operation unsuccessful");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody ItemDTO itemDTO) {
        try {
            return itemService.update(itemDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to update item. Operation unsuccessful");
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findById(@PathVariable long code) {
        try {
            return itemService.findById(code);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch item. Operation unsuccessful");
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllCustomers() {
        try {
            return itemService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch item details. Operation unsuccessful");
        }
    }
}
