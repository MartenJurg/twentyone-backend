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

    public UserInventoryDto getByUsername(String username) throws UserNotFoundException {

        UserInventory userInventory = userInventoryRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return new UserInventoryDto(userInventory);
    }
}
