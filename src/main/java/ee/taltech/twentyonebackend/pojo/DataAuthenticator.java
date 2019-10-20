package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.service.UserDataService;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataAuthenticator {

    private Map<String, Integer> skillData = new HashMap<>();

    private void makeSkillDataDict(){
        skillData.put("dumpling", 0);
        skillData.put("pasta", 10);
        skillData.put("duck", 30);
        skillData.put("gloves", 0);
        skillData.put("hat", 10);
        skillData.put("sweater", 30);
        skillData.put("water", 0);
        skillData.put("applejuice", 10);
        skillData.put("gintonic", 30);
        skillData.put("paper", 0);
        skillData.put("watch", 10);
        skillData.put("phone", 30);
    }
    @Resource
    UserDataService userDataService;

    @Resource
    UserInventoryService userInventoryService;

    public boolean authenticateCooking(String username, String skillName){
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        return userDataDto.getCooking() >= skillData.get(skillName);
    }

    public boolean authenticateCrafting(String username, String skillName) {
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        return userDataDto.getCrafting() >= skillData.get(skillName);
    }

    public boolean authenticateThieving(String username, String skillName) {
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        return userDataDto.getThieving() >= skillData.get(skillName);
    }

    public boolean authenticateBeverage(String username, String skillName) {
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        return userDataDto.getBeverage() >= skillData.get(skillName);
    }

    public boolean authenticateBuilding(String username) {
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        UserInventoryDto userInventoryDto = userInventoryService.getByUsername(username);
        switch (userDataDto.getHouse()) {
            case 0:
                return (userDataDto.getCash() >= 5000
                        && userInventoryDto.getPaper() >= 100
                        && userInventoryDto.getGloves() >= 100);
            case 1:
                return (userDataDto.getCash() >= 50000
                        && userInventoryDto.getHats() >= 100
                        && userInventoryDto.getWatches() >= 100);
            case 2:
                return (userDataDto.getCash() >= 500000
                        && userInventoryDto.getSweaters() >= 100
                        && userInventoryDto.getPhones() >= 100);
            default:
                return false;
        }
    }
}
