package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.UserDataService;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UpdateGameData {

    @Resource
    UserDataService userDataService;

    @Resource
    UserInventoryService userInventoryService;

    public void cook(String username, String dish){
        userDataService.updateCooking(username, dish);
    }

    public void craft(String username, String craft) {
        userInventoryService.updateCrafting(username, craft);
    }

    public void beverage(String username, String drink) {
        userDataService.updateBeverage(username, drink);
    }

    public void steal(String username, String item) {
        userInventoryService.updateThieving(username, item);
    }

    public void sellCrafts(String username) {
        userDataService.updateCrafting(username);
    }

    public void sellThievingItems(String username) {
        userDataService.updateThieving(username);
    }
}
