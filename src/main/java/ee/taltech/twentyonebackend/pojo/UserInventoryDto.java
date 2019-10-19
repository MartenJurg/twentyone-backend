package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.model.UserInventory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInventoryDto {

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NotBlank
    private int paper;

    @NotBlank
    private int watches;

    @NotBlank
    private int phones;

    @NotBlank
    private int gloves;

    @NotBlank
    private int hats;

    @NotBlank
    private int sweaters;

    public UserInventoryDto(UserInventory userInventory) {
        this.username = userInventory.getUsername();
        this.paper = userInventory.getPaper();
        this.watches = userInventory.getWatches();
        this.phones = userInventory.getPhones();
        this.gloves = userInventory.getGloves();
        this.hats = userInventory.getHats();
        this.sweaters = userInventory.getSweaters();
    }

    public String getUsername() {
        return username;
    }

    public int getPaper() {
        return paper;
    }

    public int getWatches() {
        return watches;
    }

    public int getPhones() {
        return phones;
    }

    public int getGloves() {
        return gloves;
    }

    public int getHats() {
        return hats;
    }

    public int getSweaters() {
        return sweaters;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public void setWatches(int watches) {
        this.watches = watches;
    }

    public void setPhones(int phones) {
        this.phones = phones;
    }

    public void setGloves(int gloves) {
        this.gloves = gloves;
    }

    public void setHats(int hats) {
        this.hats = hats;
    }

    public void setSweaters(int sweaters) {
        this.sweaters = sweaters;
    }
}
