package pl.idczak.warehouseman2.item;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.IncorrectDataException;
import pl.idczak.warehouseman2.devivery.DeliveryDto;

import javax.transaction.Transactional;
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

    List<ItemDto> findALlById(Long id) {
        return itemRepository.findAllById(id)
                .stream()
                .map(ItemMapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<ItemDto> findById(Long id) {
        return itemRepository.findById(id).map(ItemMapper::toDto);
    }

    ItemDto saveItem(ItemDto itemDto) {
        if (itemDto.getName() == null || "".equals(itemDto.getName()))
            throw new IncorrectDataException("You must enter a name of an Item");
        if (itemDto.getQuantityOnOnePallet() == null  || itemDto.getQuantityOnOnePallet() <= 0)
            throw new IncorrectDataException("You must enter correct number");
        Optional<Item> itemByName = itemRepository.findByNameIgnoreCase(itemDto.getName());
        itemByName.ifPresent(item -> {
            throw new IncorrectDataException("You cannot duplicate item names - " + itemDto.getName());
        });
        return saveAndReturn(itemDto);
    }

    ItemDto editItem(ItemDto itemDto) {
        if (itemDto.getQuantityOnOnePallet() == null || itemDto.getQuantityOnOnePallet() <= 0)
            throw new IncorrectDataException("You must enter correct number");
        Optional<Item> itemById = itemRepository.findById(itemDto.getId());
        itemById.orElseThrow(() -> new IncorrectDataException("Incorrect ID"));
        return saveAndReturn(itemDto);
    }

    private ItemDto saveAndReturn(ItemDto itemDto) {
        Item itemEntity = ItemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(itemEntity);
        return ItemMapper.toDto(savedItem);
    }

    @Transactional
    public ItemDto updateItemDelivery(DeliveryDto deliveryDto) {
        Item itemEntity = getItemOrThrowException(deliveryDto);
        itemEntity.setPallets(itemEntity.getPallets() + deliveryDto.getPalletsQuantity());
        return ItemMapper.toDto(itemEntity);
    }

    @Transactional
    public ItemDto updateItemDeparture(DeliveryDto deliveryDto) {
        Item itemEntity = getItemOrThrowException(deliveryDto);
        Long palletsAvailability = itemEntity.getPallets();
        if (deliveryDto.getPalletsQuantity() > palletsAvailability && palletsAvailability == 0)
            throw new IncorrectDataException("There are no pallets with the " +
                    itemEntity.getName() + " Item in the Warehouse");
        if (deliveryDto.getPalletsQuantity() > palletsAvailability && palletsAvailability == 1)
            throw new IncorrectDataException("There is only " + palletsAvailability + " pallet with the " +
                    itemEntity.getName() + " Item in the Warehouse");
        if (deliveryDto.getPalletsQuantity() > palletsAvailability)
            throw new IncorrectDataException("There are only " + palletsAvailability + " pallets with the " +
                    itemEntity.getName() + " Item in the Warehouse");
        itemEntity.setPallets(palletsAvailability - deliveryDto.getPalletsQuantity());
        return ItemMapper.toDto(itemEntity);
    }

    private Item getItemOrThrowException(DeliveryDto deliveryDto) {
        if (deliveryDto.getItem() == null || "".equals(deliveryDto.getItem()))
            throw new IncorrectDataException("You must select an Item");
        if (deliveryDto.getWarehouseman() == null || "".equals(deliveryDto.getWarehouseman()))
            throw new IncorrectDataException("You must select a Warehouseman");
        if (deliveryDto.getPalletsQuantity() == null || deliveryDto.getPalletsQuantity() <= 0)
            throw new IncorrectDataException("Incorrect Quantity of Pallets");
        Optional<Item> itemEntity = itemRepository.findByName(deliveryDto.getItem());
        itemEntity.orElseThrow(() -> new IncorrectDataException("There is no such Item"));
        return itemEntity.get();
    }

    void deleteById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        itemOptional.orElseThrow(() -> new IncorrectDataException("There is no such Item"));
        if (!itemOptional.get().getDeliveries().isEmpty())
            throw new IncorrectDataException("You cannot delete an Item that has already been delivered");
        itemRepository.deleteById(id);
    }
}
