package pl.idczak.warehouseman2.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByNameContainingIgnoreCase(String name);
}
