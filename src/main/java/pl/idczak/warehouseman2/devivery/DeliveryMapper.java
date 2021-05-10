package pl.idczak.warehouseman2.devivery;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.item.Item;
import pl.idczak.warehouseman2.item.ItemRepository;
import pl.idczak.warehouseman2.transporter.Transporter;
import pl.idczak.warehouseman2.transporter.TransporterRepository;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;
import pl.idczak.warehouseman2.warehouseman.WarehousemanRepository;

import java.util.Optional;

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

    DeliveryDto toDto(Delivery entity) {
        DeliveryDto dto = new DeliveryDto();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setPalletsQuantity(entity.getPalletsQuantity());
        dto.setDeparture(entity.isDeparture());
        Optional<Item> item = itemRepository.findById(entity.getItem().getId());
        item.ifPresent(i -> {
            dto.setItemsQuantity(entity.getPalletsQuantity() * i.getQuantityOnOnePallet());
            dto.setItem(entity.getItem().getName());
        });
        if (entity.getTransporter() != null)
            dto.setTransporter(entity.getTransporter().getName());
        if (entity.getWarehouseman() != null)
            dto.setWarehouseman(entity.getWarehouseman().getName());
        return dto;
    }

    Delivery toEntity(DeliveryDto dto) {
        Delivery entity = new Delivery();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setPalletsQuantity(dto.getPalletsQuantity());
        entity.setDeparture(dto.isDeparture());
        Optional<Transporter> transporter = transporterRepository.findByName(dto.getTransporter());
        transporter.ifPresent(entity::setTransporter);
        Optional<Warehouseman> warehouseman = warehousemanRepository.findByName(dto.getWarehouseman());
        warehouseman.ifPresent(entity::setWarehouseman);
        Optional<Item> item = itemRepository.findByName(dto.getItem());
        item.ifPresent(entity::setItem);
        return entity;
    }
}
