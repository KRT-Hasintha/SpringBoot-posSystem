package org.example.posbackend.controller;

import jakarta.validation.Valid;
import org.example.posbackend.dto.ItemDto;
import org.example.posbackend.service.impl.ItemServiceImpl;
import org.example.posbackend.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemService;

    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<String>> saveItem(@RequestBody @Valid ItemDto itemDto) {

        itemService.saveItem(itemDto);
        return new ResponseEntity<>(new APIResponse<>(201,"Item Saved", null), HttpStatus.CREATED);    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<APIResponse<String>> updateItem(@RequestBody @Valid ItemDto itemDto) {
        itemService.updateItem(itemDto);
        return new ResponseEntity<>(new APIResponse<>(200,"Item Updated", null), HttpStatus.OK);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteItem(@PathVariable @Valid String id) {
        itemService.deleteItem(id);

        return ResponseEntity.ok(new APIResponse<>(200,"Item Deleted", null));
    }

    @GetMapping
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable String id) {
        return itemService.searchItem(id);
    }

}
