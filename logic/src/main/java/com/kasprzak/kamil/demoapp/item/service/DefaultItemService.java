package com.kasprzak.kamil.demoapp.item.service;

import com.kasprzak.kamil.demoapp.item.ItemEntity;
import com.kasprzak.kamil.demoapp.item.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public void createItem(String name, String description) {
        var item = new ItemEntity();
        item.setName(name);
        item.setDescription(description);
        itemRepository.save(item);
    }
}
