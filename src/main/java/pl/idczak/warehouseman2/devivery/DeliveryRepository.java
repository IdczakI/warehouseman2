package pl.idczak.warehouseman2.devivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByDeparture(boolean departure);

    @Query("select a from Delivery a where (" +
            " a.item in (select a.item from Item where lower(name) like lower(concat('%',:search,'%')))" +
            "or a.transporter in (select a.transporter from Transporter where lower(name) like lower(concat('%',:search,'%')))" +
            "or a.warehouseman in (select a.warehouseman from Warehouseman where lower(name) like lower(concat('%',:search,'%'))))" +
            "and a.departure = :departure")
    List<Delivery> findAllByBase(@Param("search") String search, @Param("departure") boolean departure);
}
