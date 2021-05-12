package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.IncorrectDataException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransporterService {

    private TransporterRepository transporterRepository;

    public TransporterService(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    public List<TransporterDto> findAll() {
        return transporterRepository.findAll()
                .stream()
                .map(TransporterMapper::toDto)
                .collect(Collectors.toList());
    }

    List<TransporterDto> findAllByBase(String name) {
        return transporterRepository.findAllByBase(name)
                .stream()
                .map(TransporterMapper::toDto)
                .collect(Collectors.toList());
    }

    Optional<TransporterDto> findById(Long id) {
        return transporterRepository.findById(id).map(TransporterMapper::toDto);
    }

    TransporterDto saveTransporter(TransporterDto transporterDto) {
        if (transporterDto.getName() == null || "".equals(transporterDto.getName()))
            throw new IncorrectDataException("Transporters must have an ID");
        Optional<Transporter> transporterByName = transporterRepository.findByNameIgnoreCase(transporterDto.getName());
        transporterByName.ifPresent(transporter -> {
            throw new IncorrectDataException("You cannot duplicate transporter IDs - " + transporterDto.getName());
        });
        return saveAndReturn(transporterDto);
    }

    TransporterDto editTransporter(TransporterDto transporterDto) {
        Optional<Transporter> transporterById = transporterRepository.findById(transporterDto.getId());
        transporterById.orElseThrow(() -> new IncorrectDataException("Incorrect ID"));
        return saveAndReturn(transporterDto);
    }

    private TransporterDto saveAndReturn(TransporterDto transporterDto) {
        Transporter transporterEntity = TransporterMapper.toEntity(transporterDto);
        Transporter savedTransporter = transporterRepository.save(transporterEntity);
        return TransporterMapper.toDto(savedTransporter);
    }
}
