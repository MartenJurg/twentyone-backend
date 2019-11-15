package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.model.UserData;
import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.repository.UserDataRepository;
import ee.taltech.twentyonebackend.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserSellingService {

    @Resource
    UserDataRepository userDataRepository;

    @Resource
    UserInventoryRepository userInventoryRepository;


    public void updateStreets(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        for (int i = 0; i != userInventory.getPaper(); ) {
            userData.setCash(userData.getCash() + 5);
            userInventory.setPaper(userInventory.getPaper() - 1);
        }
        for (int i = 0; i != userInventory.getWatches(); ) {
            userData.setCash(userData.getCash() + 20);
            userInventory.setWatches(userInventory.getWatches() - 1);
        }
        for (int i = 0; i != userInventory.getPhones(); ) {
            userData.setCash(userData.getCash() + 50);
            userInventory.setPhones(userInventory.getPhones() - 1);
        }
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

    public void saveData(UserData userData) {
        userDataRepository.save(userData);
    }

    public void saveInventory(UserInventory userInventory) {
        userInventoryRepository.save(userInventory);
    }
}
