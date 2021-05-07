package pl.idczak.warehouseman2.devivery;

import java.time.LocalDateTime;
import java.util.List;

public class DeliveryDto {

    private Long id;
    private LocalDateTime date;
    private Long itemsQuantity;
    private boolean export;
    private List<String> items;
    private String shipper;
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

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getWarehouseman() {
        return warehouseman;
    }

    public void setWarehouseman(String warehouseman) {
        this.warehouseman = warehouseman;
    }
}
