package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.IncorrectDataException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDto> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    List<ItemDto> findAllByName(String name) {
        return itemRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<ItemDto> findById(Long id) {
        return itemRepository.findById(id).map(ItemMapper::toDto);
    }

    ItemDto saveItem(ItemDto itemDto) {
        if (itemDto.getName() == null || itemDto.getQuantityOnOnePallet() == null || "".equals(itemDto.getName()))
            throw new IncorrectDataException("You must fill all required fields");
        Optional<Item> itemByName = itemRepository.findByNameIgnoreCase(itemDto.getName());
        itemByName.ifPresent(item -> {
            throw new IncorrectDataException("You cannot duplicate item names - " + itemDto.getName());
        });
        return saveAndReturn(itemDto);
    }

    ItemDto editItem(ItemDto itemDto) {
        if (itemDto.getQuantityOnOnePallet() == null)
            throw new IncorrectDataException("You must fill all required fields");
        Optional<Item> itemById = itemRepository.findById(itemDto.getId());
        itemById.orElseThrow(() -> new IncorrectDataException("Incorrect ID"));
        return saveAndReturn(itemDto);
    }

    private ItemDto saveAndReturn(ItemDto itemDto) {
        Item itemEntity = ItemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(itemEntity);
        return ItemMapper.toDto(savedItem);
    }
}
