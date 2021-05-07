package pl.idczak.warehouseman2.item;

public class ItemDto {

    private Long id;
    private String name;
    private String description;
    private Long quantityOnOnePallet;
    private Long availability;

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

    public Long getAvailability() {
        return availability;
    }

    public void setAvailability(Long availability) {
        this.availability = availability;
    }
}
