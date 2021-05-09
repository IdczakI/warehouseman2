package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    List<ItemDto> findAll(){
        return itemRepository.findAll()
                .stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    List<ItemDto> findAllByName(String name){
        return itemRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }
}
