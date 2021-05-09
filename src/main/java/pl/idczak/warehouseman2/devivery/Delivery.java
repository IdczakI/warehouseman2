package pl.idczak.warehouseman2.devivery;

import pl.idczak.warehouseman2.item.Item;
import pl.idczak.warehouseman2.transporter.Transporter;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Long itemsQuantity;
    private boolean departure;
    @ManyToMany
    @JoinTable(name = "delivery_item",
    joinColumns = {@JoinColumn(name = "delivery_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    private List<Item> items = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "transporter_id")
    private Transporter transporter;
    @ManyToOne
    @JoinColumn(name = "warehouseman_id")
    private Warehouseman warehouseman;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getItemsQuantity() {
        return itemsQuantity;
    }

    public void setItemsQuantity(Long itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public boolean isDeparture() {
        return departure;
    }

    public void setDeparture(boolean export) {
        this.departure = export;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Transporter getShipper() {
        return transporter;
    }

    public void setShipper(Transporter transporter) {
        this.transporter = transporter;
    }

    public Warehouseman getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(Warehouseman warehouseman) {
        this.warehouseman = warehouseman;
    }
}
