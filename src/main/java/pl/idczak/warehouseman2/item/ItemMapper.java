package pl.idczak.warehouseman2.item;

public class ItemMapper {

    static ItemDto toDto(Item entity){
        ItemDto dto = new ItemDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setQuantityOnOnePallet(entity.getQuantityOnOnePallet());
        dto.setPallets(entity.getPallets());
        dto.setAvailability(entity.getQuantityOnOnePallet() * entity.getPallets());
        return dto;
    }

    static Item toEntity(ItemDto dto){
        Item entity = new Item();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setQuantityOnOnePallet(dto.getQuantityOnOnePallet());
        entity.setPallets(0L);
        return entity;
    }
}
