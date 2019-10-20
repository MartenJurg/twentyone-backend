package ee.taltech.twentyonebackend.pojo.response;

import ee.taltech.twentyonebackend.pojo.UserDataDto;

public class DataResponse {

    private String cash;

    private String house;

    private String fame;

    private String strength;

    private String defence;

    private String cooking;

    private String thieving;

    private String crafting;

    private String beverage;

    public DataResponse() {
    }

    public DataResponse(UserDataDto userDataDto) {
        this.cash = "" + userDataDto.getCash();
        this.house = "" + userDataDto.getHouse();
        this.fame = "" + userDataDto.getFame();
        this.strength = "" + userDataDto.getStrenght();
        this.defence = "" + userDataDto.getDefence();
        this.cooking = "" + userDataDto.getCooking();
        this.thieving = "" + userDataDto.getThieving();
        this.crafting = "" + userDataDto.getCrafting();
        this.beverage = "" + userDataDto.getBeverage();
    }

    public String getCash() {
        return cash;
    }

    public String getHouse() {
        return house;
    }

    public String getFame() {
        return fame;
    }

    public String getStrength() {
        return strength;
    }

    public String getDefence() {
        return defence;
    }

    public String getCooking() {
        return cooking;
    }

    public String getThieving() {
        return thieving;
    }

    public String getCrafting() {
        return crafting;
    }

    public String getBeverage() {
        return beverage;
    }
}
