package pl.idczak.warehouseman2.warehouseman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WarehousemanRepository extends JpaRepository<Warehouseman, Long> {

    @Query("select a from Warehouseman a where lower(a.name) like lower(concat('%',:search,'%'))" +
            "or lower(a.firstName) like lower(concat('%',:search,'%'))" +
            "or lower(a.lastName) like lower(concat('%',:search,'%'))")
    List<Warehouseman> findAllByBase(@Param("search") String search);

    Optional<Warehouseman> findByName(String name);
}
