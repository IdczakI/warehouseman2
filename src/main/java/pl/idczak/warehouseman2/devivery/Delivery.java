package pl.idczak.warehouseman2.devivery;

import pl.idczak.warehouseman2.item.Item;
import pl.idczak.warehouseman2.transporter.Transporter;
import pl.idczak.warehouseman2.warehouseman.Warehouseman;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private Long palletsQuantity;
    private boolean departure;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
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

    public Long getPalletsQuantity() {
        return palletsQuantity;
    }

    public void setPalletsQuantity(Long itemsQuantity) {
        this.palletsQuantity = itemsQuantity;
    }

    public boolean isDeparture() {
        return departure;
    }

    public void setDeparture(boolean export) {
        this.departure = export;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Transporter getTransporter() {
        return transporter;
    }

    public void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }

    public Warehouseman getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(Warehouseman warehouseman) {
        this.warehouseman = warehouseman;
    }
}
