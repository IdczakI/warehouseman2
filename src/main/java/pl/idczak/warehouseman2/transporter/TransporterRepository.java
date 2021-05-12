package pl.idczak.warehouseman2.transporter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransporterRepository extends JpaRepository<Transporter, Long> {

    @Query("select a from Transporter a where lower(a.name) like lower(concat('%',:search,'%'))" +
            "or lower(a.firstName) like lower(concat('%',:search,'%'))" +
            "or lower(a.lastName) like lower(concat('%',:search,'%'))" +
            "or lower(a.company) like lower(concat('%',:search,'%'))" +
            "or lower(a.vehicleNumber) like lower(concat('%',:search,'%'))")
    List<Transporter> findAllByBase(@Param("search") String search);

    Optional<Transporter> findByName(String name);

    Optional<Transporter> findByNameIgnoreCase(String name);

    List<Transporter> findAllById(Long id);
}
