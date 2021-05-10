package pl.idczak.warehouseman2.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameContainingIgnoreCase(String name);

    Optional<Item> findByName(String name);

    Optional<Item> findByNameIgnoreCase(String name);
}
