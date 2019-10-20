package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.model.UserData;
import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.pojo.UserInventoryDto;
import ee.taltech.twentyonebackend.repository.UserDataRepository;
import ee.taltech.twentyonebackend.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInventoryService {

    @Resource
    UserInventoryRepository userInventoryRepository;

    @Resource
    UserDataRepository userDataRepository;

    public UserInventoryDto getByUsername(String username) throws UserNotFoundException {

        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return new UserInventoryDto(userInventory);
    }

    public void updateCrafting(String username, String craft) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (craft){
            case "gloves":
                userInventory.setGloves(userInventory.getGloves() + 1);
                userData.setCraftingxp(userData.getCraftingxp() + 1);
                userData.setCrafting(userData.getCraftingxp() / 50);
                saveInventory(userInventory);
                break;
            case "hat":
                userInventory.setHats(userInventory.getHats() + 1);
                userData.setCraftingxp(userData.getCraftingxp() + 2);
                userData.setCrafting(userData.getCraftingxp() / 50);
                saveInventory(userInventory);
                break;
            case "sweater":
                userInventory.setSweaters(userInventory.getSweaters() + 1);
                userData.setCraftingxp(userData.getCraftingxp() + 3);
                userData.setCrafting(userData.getCraftingxp() / 50);
                saveInventory(userInventory);
                break;
        }
    }

    public void updateThieving(String username, String thieving) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (thieving){
            case "paper":
                userInventory.setPaper(userInventory.getPaper() + 1);
                userData.setThievingxp(userData.getThievingxp() + 1);
                userData.setThieving(userData.getThievingxp() / 50);
                saveInventory(userInventory);
                break;
            case "watch":
                userInventory.setWatches(userInventory.getWatches() + 1);
                userData.setThievingxp(userData.getThievingxp() + 2);
                userData.setThieving(userData.getThievingxp() / 50);
                saveInventory(userInventory);
                break;
            case "phone":
                userInventory.setPhones(userInventory.getPhones() + 1);
                userData.setThievingxp(userData.getThievingxp() +3);
                userData.setThieving(userData.getThievingxp() / 50);
                saveInventory(userInventory);
                break;
        }
    }

    public void saveInventory(UserInventory userInventory) {
        userInventoryRepository.save(userInventory);
    }
}
