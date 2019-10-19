package ee.taltech.twentyonebackend.pojo.response;

import ee.taltech.twentyonebackend.pojo.UserInventoryDto;

public class InventoryResponse {

    private String paper;

    private String watches;

    private String phones;

    private String gloves;

    private String hats;

    private String sweaters;

    public InventoryResponse() {
    }

    public InventoryResponse(UserInventoryDto userInventoryDto) {
        this.paper = "" + userInventoryDto.getPaper();
        this.watches = "" + userInventoryDto.getWatches();
        this.phones = "" + userInventoryDto.getPhones();
        this.gloves = "" + userInventoryDto.getGloves();
        this.hats = "" + userInventoryDto.getHats();
        this.sweaters = "" + userInventoryDto.getSweaters();
    }

    public String getPaper() {
        return paper;
    }

    public String getWatches() {
        return watches;
    }

    public String getPhones() {
        return phones;
    }

    public String getGloves() {
        return gloves;
    }

    public String getHats() {
        return hats;
    }

    public String getSweaters() {
        return sweaters;
    }
}
