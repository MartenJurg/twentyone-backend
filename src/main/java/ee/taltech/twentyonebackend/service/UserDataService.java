package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.model.UserData;
import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.pojo.UserDataDto;
import ee.taltech.twentyonebackend.repository.UserDataRepository;
import ee.taltech.twentyonebackend.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserDataService {

    @Resource
    UserDataRepository userDataRepository;

    @Resource
    UserInventoryRepository userInventoryRepository;

    public UserDataDto getByUsername(String username) throws UserNotFoundException {

        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return new UserDataDto(userData);
    }

    public void updateCooking(String username, String dish) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (dish){
            case "dumpling":
                userData.setCash(userData.getCash() + 5);
                userData.setCookingxp(userData.getCookingxp() + 1);
                userData.setCooking(userData.getCookingxp() / 50);
                saveData(userData);
                break;
            case "pasta":
                userData.setCash(userData.getCash() + 20);
                userData.setCookingxp(userData.getCookingxp() + 2);
                userData.setCooking(userData.getCookingxp() / 50);
                saveData(userData);
                break;
            case "duck":
                userData.setCash(userData.getCash() + 50);
                userData.setCookingxp(userData.getCookingxp() + 3);
                userData.setCooking(userData.getCookingxp() / 50);
                saveData(userData);
                break;
        }
    }

    public void updateCrafting(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        for (int i = 0; i != userInventory.getGloves();) {
            userData.setCash(userData.getCash() + 5);
            userInventory.setGloves(userInventory.getGloves() - 1);
        }
        for (int i = 0; i != userInventory.getHats();) {
            userData.setCash(userData.getCash() + 20);
            userInventory.setHats(userInventory.getHats() - 1);
        }
        for (int i = 0; i != userInventory.getSweaters();) {
            userData.setCash(userData.getCash() + 50);
            userInventory.setSweaters(userInventory.getSweaters() - 1);
        }
        saveInventory(userInventory);
    }

    public void updateBeverage(String username, String beverage) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (beverage){
            case "water":
                userData.setCash(userData.getCash() + 5);
                userData.setBeveragexp(userData.getBeveragexp() + 1);
                userData.setBeverage(userData.getBeveragexp() / 50);
                saveData(userData);
                break;
            case "applejuice":
                userData.setCash(userData.getCash() + 20);
                userData.setBeveragexp(userData.getBeveragexp() + 2);
                userData.setBeverage(userData.getBeveragexp() / 50);
                saveData(userData);
                break;
            case "gintonic":
                userData.setCash(userData.getCash() + 50);
                userData.setBeveragexp(userData.getBeveragexp() + 3);
                userData.setBeverage(userData.getBeveragexp() / 50);
                saveData(userData);
                break;
        }
    }

    public void updateStrength(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        userData.setStrenght(userData.getStrenghtxp() / 50);
        userData.setStrenghtxp(userData.getStrenghtxp() + 2);
        saveData(userData);
    }

    public void updateDefence(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        userData.setDefence(userData.getDefencexp() / 50);
        userData.setDefencexp(userData.getDefencexp() + 2);
        saveData(userData);
    }

    public void updateThieving(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        for (int i = 0; i != userInventory.getPaper();) {
            userData.setCash(userData.getCash() + 5);
            userInventory.setPaper(userInventory.getPaper() - 1);
        }
        for (int i = 0; i != userInventory.getHats();) {
            userData.setCash(userData.getCash() + 20);
            userInventory.setWatches(userInventory.getWatches() - 1);
        }
        for (int i = 0; i != userInventory.getPhones();) {
            userData.setCash(userData.getCash() + 50);
            userInventory.setPhones(userInventory.getPhones() - 1);
        }
        saveInventory(userInventory);
    }

    public void updateFame(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        userData.setFame((userData.getBeverage()
                + userData.getCooking()
                + userData.getCrafting()
                + userData.getThieving()
                + userData.getDefence()
                + userData.getStrength())
                / 6);
        saveData(userData);
    }

    public void saveData(UserData userData) {
        userDataRepository.save(userData);
    }

    public void saveInventory(UserInventory userInventory) {
        userInventoryRepository.save(userInventory);
    }
}
