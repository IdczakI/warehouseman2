package pl.idczak.warehouseman2.devivery;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.item.Item;
import pl.idczak.warehouseman2.item.ItemRepository;
import pl.idczak.warehouseman2.transporter.Transporter;
import pl.idczak.warehouseman2.transporter.TransporterRepository;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;
import pl.idczak.warehouseman2.warehouseman.WarehousemanRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryMapper {

    private ItemRepository itemRepository;
    private WarehousemanRepository warehousemanRepository;
    private TransporterRepository transporterRepository;

    public DeliveryMapper(ItemRepository itemRepository,
                          WarehousemanRepository warehousemanRepository,
                          TransporterRepository transporterRepository) {
        this.itemRepository = itemRepository;
        this.warehousemanRepository = warehousemanRepository;
        this.transporterRepository = transporterRepository;
    }

    DeliveryDto toDto(Delivery entity){
        DeliveryDto dto = new DeliveryDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setItemsQuantity(entity.getItemsQuantity());
        dto.setDeparture(dto.isDeparture());
        dto.setItems(entity.getItems().stream().map(Item::getName).collect(Collectors.toList()));
        dto.setTransporter(entity.getTransporter().getName());
        dto.setWarehouseman(entity.getWarehouseman().getName());
        return dto;
    }

    Delivery toEntity(DeliveryDto dto){
        Delivery entity = new Delivery();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setItemsQuantity(dto.getItemsQuantity());
        entity.setDeparture(dto.isDeparture());
        Optional<Transporter> transporter = transporterRepository.findAllByName(dto.getTransporter());
        transporter.ifPresent(entity::setTransporter);
        Optional<Warehouseman> warehouseman = warehousemanRepository.findAllByName(dto.getWarehouseman());
        warehouseman.ifPresent(entity::setWarehouseman);
        return entity;
    }
}
