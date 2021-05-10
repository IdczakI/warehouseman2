package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.DuplicateException;
import pl.idczak.warehouseman2.item.ItemMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransporterService {

    private TransporterRepository transporterRepository;

    public TransporterService(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    List<TransporterDto> findAll(){
        return transporterRepository.findAll()
                .stream()
                .map(TransporterMapper::toDto)
                .collect(Collectors.toList());
    }

    List<TransporterDto> findAllByBase(String name){
        return transporterRepository.findAllByBase(name)
                .stream()
                .map(TransporterMapper::toDto)
                .collect(Collectors.toList());
    }

    TransporterDto saveTransporter(TransporterDto transporterDto){
        Optional<Transporter> transporterByName = transporterRepository.findByNameIgnoreCase(transporterDto.getName());
        transporterByName.ifPresent(transporter -> {
            throw new DuplicateException("You cannot duplicate transporter IDs - " + transporterDto.getName());
        });
        Transporter transporterEntity = TransporterMapper.toEntity(transporterDto);
        Transporter savedTransporter = transporterRepository.save(transporterEntity);
        return TransporterMapper.toDto(savedTransporter);
    }
}
