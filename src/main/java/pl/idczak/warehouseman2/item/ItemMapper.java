package pl.idczak.warehouseman2.item;

public class ItemMapper {

    static ItemDto toDto(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setDescription(item.getDescription());
        itemDto.setQuantityOnOnePallet(item.getQuantityOnOnePallet());
        itemDto.setPallets(item.getPallets());
        itemDto.setAvailability(item.getQuantityOnOnePallet() * item.getPallets());
        return itemDto;
    }

    static Item toEntity(ItemDto itemDto){
        Item itemEntity = new Item();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());
        itemEntity.setDescription(itemDto.getDescription());
        itemEntity.setQuantityOnOnePallet(itemDto.getQuantityOnOnePallet());
        itemEntity.setPallets(itemDto.getPallets());
        return itemEntity;
    }
}
