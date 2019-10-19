package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.UserDataService;

import javax.annotation.Resource;

public class UpdateGameData {

    @Resource
    UserDataService userDataService;

    public void cook(String username, String dish){
        userDataService.updateCooking(username, dish);
    }

    public void craft(String username, String craft) {
        userDataService.updateCrafting(username, craft);
    }

    public void beverage(String username, String drink) {
        userDataService.updateBeverage(username, drink);
    }

    public void steal(String username, String item) {
        userDataService.updateThieving(username, item);
    }
}
