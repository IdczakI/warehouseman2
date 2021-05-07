package pl.idczak.warehouseman2.devivery;

import pl.idczak.warehouseman2.item.Item;
import pl.idczak.warehouseman2.shipper.Shipper;
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
    private boolean export;
    @ManyToMany
    @JoinTable(name = "delivery_item",
    joinColumns = {@JoinColumn(name = "delivery_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
    private List<Item> items = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;
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

    public boolean isExport() {
        return export;
    }

    public void setExport(boolean export) {
        this.export = export;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Warehouseman getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(Warehouseman warehouseman) {
        this.warehouseman = warehouseman;
    }
}
