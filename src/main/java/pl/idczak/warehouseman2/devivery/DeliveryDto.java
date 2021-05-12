package pl.idczak.warehouseman2.devivery;


public class DeliveryDto {

    private Long id;
    private String date;
    private Long palletsQuantity;
    private Long itemsQuantity;
    private boolean departure;
    private String item;
    private String transporter;
    private String warehouseman;
    private Long itemId;
    private Long warehousemanId;
    private Long transporterId;

    public Long getWarehousemanId() {
        return warehousemanId;
    }

    public void setWarehousemanId(Long warehousemanId) {
        this.warehousemanId = warehousemanId;
    }

    public Long getTransporterId() {
        return transporterId;
    }

    public void setTransporterId(Long transporterId) {
        this.transporterId = transporterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
