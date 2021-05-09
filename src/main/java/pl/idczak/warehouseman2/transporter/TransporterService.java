package pl.idczak.warehouseman2.transporter;

import org.springframework.stereotype.Service;
import pl.idczak.warehouseman2.item.ItemMapper;

import java.util.List;
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
}
