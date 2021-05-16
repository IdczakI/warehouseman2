package pl.idczak.warehouseman2.warehouseman;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehousemanService {

    private WarehousemanRepository warehousemanRepository;

    public WarehousemanService(WarehousemanRepository warehousemanRepository) {
        this.warehousemanRepository = warehousemanRepository;
    }

    public List<WarehousemanDto> findAll() {
        return warehousemanRepository.findAll()
                .stream()
                .map(WarehousemanMapper::toDto)
                .collect(Collectors.toList());
    }

    List<WarehousemanDto> findAllByBase(String name) {
        return warehousemanRepository.findAllByBase(name)
                .stream()
                .map(WarehousemanMapper::toDto)
                .collect(Collectors.toList());
    }

    List<WarehousemanDto> findAllById(Long id) {
        return warehousemanRepository.findAllById(id)
                .stream()
                .map(WarehousemanMapper::toDto)
                .collect(Collectors.toList());
    }

    public String getLoggedInWarehouseman() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
