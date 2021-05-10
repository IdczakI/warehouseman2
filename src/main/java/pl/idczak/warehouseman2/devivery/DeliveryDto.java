package pl.idczak.warehouseman2.devivery;

import java.time.LocalDateTime;

public class DeliveryDto {

    private Long id;
    private LocalDateTime date;
    private Long palletsQuantity;
    private Long itemsQuantity;
    private boolean departure;
    private String item;
    private String transporter;
    private String warehouseman;

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

    public void setPalletsQuantity(Long palletsQuantity) {
        this.palletsQuantity = palletsQuantity;
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

    public void setDeparture(boolean departure) {
        this.departure = departure;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTransporter() {
        return transporter;
    }

    public void setTransporter(String transporter) {
        this.transporter = transporter;
    }

    public String getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(String warehouseman) {
        this.warehouseman = warehouseman;
    }
}
