package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.UserDataService;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import ee.taltech.twentyonebackend.service.UserSellingService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UpdateGameData {

    @Resource
    UserDataService userDataService;

    @Resource
    UserInventoryService userInventoryService;

    @Resource
    UserSellingService userSellingService;

    public void cook(String username, String dish){
        userDataService.updateCooking(username, dish);
        userDataService.updateFame(username);
    }

    public void craft(String username, String craft) {
        userInventoryService.updateCrafting(username, craft);
        userDataService.updateFame(username);
    }

    public void beverage(String username, String drink) {
        userDataService.updateBeverage(username, drink);
        userDataService.updateFame(username);
    }

    public void steal(String username, String item) {
        userInventoryService.updateThieving(username, item);
        userDataService.updateFame(username);
    }

    public void sellAllItems(String username) {
        userSellingService.updateStreets(username);
    }

    public void trainStrength(String username) {
        userDataService.updateStrength(username);
        userDataService.updateFame(username);
    }

    public void trainDefence(String username) {
        userDataService.updateDefence(username);
        userDataService.updateFame(username);
    }

    public void houseUpgrade(String username) {

    }
}
