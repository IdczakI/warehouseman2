package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.DuplicateException;

import java.util.List;
import java.util.Optional;
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

    ItemDto saveItem(ItemDto itemDto){
        Optional<Item> itemByName = itemRepository.findByName(itemDto.getName());
        itemByName.ifPresent(item -> {
            throw new DuplicateException("An item with the name \"" + itemDto.getName() + "\" already exist.");
        });
        Item itemEntity = ItemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(itemEntity);
        return ItemMapper.toDto(savedItem);
    }
}
