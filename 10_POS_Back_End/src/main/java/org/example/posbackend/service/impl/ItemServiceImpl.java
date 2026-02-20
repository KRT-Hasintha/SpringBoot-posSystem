package org.example.posbackend.service.impl;

import org.example.posbackend.Exception.CustomException;
import org.example.posbackend.dto.ItemDto;
import org.example.posbackend.entity.Item;
import org.example.posbackend.repository.CustomerRepository;
import org.example.posbackend.repository.ItemRepository;
import org.example.posbackend.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDto itemDto) {
        if (itemDto == null) {
            throw new NullPointerException("No data found to save");
        }
        if (itemRepository.existsById(itemDto.getId())) {
            throw new CustomException("Item already exists");
        }
        itemRepository.save(modelMapper.map(itemDto, Item.class));
      //  throw new CustomException("Error while saving Item Record");
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        if (itemDto == null) {
            throw new NullPointerException("No data found to update");
        }
        itemRepository.save(modelMapper.map(itemDto, Item.class));
    }

    @Override
    public void deleteItem(String id) {
        if(!itemRepository.existsById(id)) {
            throw new CustomException("Item not found");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.findAll().stream().
                map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
    }
    public ItemDto searchItem(String id) {
        return modelMapper.map(
                itemRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Item not found")),
                ItemDto.class
        );
    }
}
