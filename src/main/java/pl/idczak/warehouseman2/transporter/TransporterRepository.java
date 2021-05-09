package pl.idczak.warehouseman2.transporter;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.idczak.warehouseman2.item.Item;

import java.util.List;

public interface TransporterRepository extends JpaRepository<Transporter, Long> {
}
