package pl.idczak.warehouseman2.devivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByDeparture(boolean departure);

    @Query("select a from Delivery a where (" +
            "lower(a.item.name)  like lower(concat('%',:search,'%'))" +
            "or lower(a.transporter.name) like lower(concat('%',:search,'%'))" +
            "or lower(a.warehouseman.name)  like lower(concat('%',:search,'%')))" +
            "and a.departure = :departure")
    List<Delivery> findAllByBase(@Param("search") String search, @Param("departure") boolean departure);
}
