package pl.idczak.warehouseman2.item;

public class ItemDto {

    private Long id;
    private String name;
    private String description;
    private Long availability;
    private Long quantityOnOnePallet;
    private Long pallets;


    public Long getPallets() {
        return pallets;
    }

    public void setPallets(Long pallets) {
        this.pallets = pallets;
    }

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
