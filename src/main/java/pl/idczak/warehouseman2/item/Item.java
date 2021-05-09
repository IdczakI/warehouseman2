package pl.idczak.warehouseman2.item;

import pl.idczak.warehouseman2.devivery.Delivery;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private Long quantityOnOnePallet;
    private Long pallets;
    @ManyToMany(mappedBy = "items")
    private List<Delivery> deliveries = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getQuantityOnOnePallet() {
        return quantityOnOnePallet;
    }

    public void setQuantityOnOnePallet(Long quantityOnOnePallet) {
        this.quantityOnOnePallet = quantityOnOnePallet;
    }

    public Long getPallets() {
        return pallets;
    }

    public void setPallets(Long availability) {
        this.pallets = availability;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
