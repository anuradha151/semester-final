package lk.anuradha.car.service.custom.impl;

import lk.anuradha.car.dto.ItemDTO;
import lk.anuradha.car.model.Item;
import lk.anuradha.car.model.ResponseModel;
import lk.anuradha.car.repository.ItemRepository;
import lk.anuradha.car.service.custom.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ResponseEntity<?> save(ItemDTO itemDTO) {
        if (itemDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find item details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        // create new item entity to call repository
        Item save = null;
        try {
            save = itemRepository.save(dtoToEntity(itemDTO));
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), e.getMessage() + "\nError. Item saving failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        if (save != null) {
            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "Item saved successfully", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Item saving failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> update(ItemDTO itemDTO) {
        if (itemDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find item details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        Optional<Item> byId = itemRepository.findById(itemDTO.getCode());
        Item item = byId.get();
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());

        // call update customer method in repository
        Item save = null;
        try {
            save = itemRepository.save(item);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), e.getMessage() + "Error. Item updating failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        if (save != null) {
            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "Item successfully updated", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Item updating failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> delete(long code) {
        Optional<Item> byId = itemRepository.findById(code);
        if (!byId.isPresent()) {
            ResponseModel res = new ResponseModel(HttpStatus.NO_CONTENT.value(), "", false);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }
        try {
            itemRepository.delete(byId.get());
            ResponseModel res = new ResponseModel(HttpStatus.OK.value(), "Item successfully removed from the system", false);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Item deletion failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> findById(long code) {
        return null;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    private Item dtoToEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setCode(itemDTO.getCode());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        return item;

    }
}
