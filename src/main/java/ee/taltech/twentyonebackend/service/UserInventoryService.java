package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.pojo.UserInventoryDto;
import ee.taltech.twentyonebackend.repository.UserInventoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInventoryService {

    @Resource
    UserInventoryRepository userInventoryRepository;

    public void updateCrafting(String username, String craft) {
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (craft){
            case "gloves":
                userInventory.setGloves(userInventory.getGloves() + 1);
                save(userInventory);
            case "hat":
                userInventory.setHats(userInventory.getHats() + 1);
                save(userInventory);
            case "sweater":
                userInventory.setSweaters(userInventory.getSweaters() + 1);
                save(userInventory);
        }
    }

    public void updateThieving(String username, String thieving) {
        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (thieving){
            case "paper":
                userInventory.setPaper(userInventory.getPaper() + 1);
                save(userInventory);
            case "watch":
                userInventory.setWatches(userInventory.getWatches() + 1);
                save(userInventory);
            case "phone":
                userInventory.setPhones(userInventory.getPhones() + 1);
                save(userInventory);
        }
    }

    private void save(UserInventory userData) {
        userInventoryRepository.save(userData);
    }
}
