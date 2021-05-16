package pl.idczak.warehouseman2.warehouseman;

public class WarehousemanMapper {

    static WarehousemanDto toDto(Warehouseman entity){
        WarehousemanDto dto = new WarehousemanDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}
