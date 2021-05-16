package pl.idczak.warehouseman2.devivery;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.IncorrectDataException;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private DeliveryRepository deliveryRepository;
    private DeliveryMapper deliveryMapper;

    public DeliveryService(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    List<DeliveryDto> findAllDeliveries() {
        return deliveryRepository.findAllByDeparture(false)
                .stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
    }

    List<DeliveryDto> findAllDepartures() {
        return deliveryRepository.findAllByDeparture(true)
                .stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
    }

    List<DeliveryDto> findAllDeliveriesByBase(String search) {
        return deliveryRepository.findAllByBase(search, false)
                .stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
    }

    List<DeliveryDto> findAllDeparturesByBase(String search) {
        return deliveryRepository.findAllByBase(search, true)
                .stream()
                .map(deliveryMapper::toDto)
                .collect(Collectors.toList());
    }

    DeliveryDto save(DeliveryDto deliveryDto){
        if (deliveryDto.getPalletsQuantity() == null || deliveryDto.getPalletsQuantity() <= 0)
            throw new IncorrectDataException("Incorrect Quantity of Pallets");
        Delivery deliveryEntity = deliveryMapper.toEntity(deliveryDto);
        Delivery savedDelivery = deliveryRepository.save(deliveryEntity);
        return deliveryMapper.toDto(savedDelivery);
    }
}
