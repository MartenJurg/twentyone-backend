package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.model.UserData;
import ee.taltech.twentyonebackend.pojo.UserDataDto;
import ee.taltech.twentyonebackend.repository.UserDataRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserDataService {

    @Resource
    UserDataRepository userDataRepository;

    public UserDataDto getByUsername(String username) throws UserNotFoundException {

        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

        return new UserDataDto(userData);
    }

    public void updateCooking(String username, String dish) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (dish){
            case "dumpling":
                userData.setCash(userData.getCash() + 5);
                save(userData);
            case "pasta":
                userData.setCash(userData.getCash() + 20);
                save(userData);
            case "duck":
                userData.setCash(userData.getCash() + 50);
                save(userData);
        }
    }

    public void updateCrafting(String username, String craft) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (craft){
            case "gloves":
                userData.setCash(userData.getCash() + 5);
                save(userData);
            case "hat":
                userData.setCash(userData.getCash() + 20);
                save(userData);
            case "sweater":
                userData.setCash(userData.getCash() + 50);
                save(userData);
        }
    }

    public void updateBeverage(String username, String beverage) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (beverage){
            case "water":
                userData.setCash(userData.getCash() + 5);
                save(userData);
            case "applejuice":
                userData.setCash(userData.getCash() + 20);
                save(userData);
            case "gintonic":
                userData.setCash(userData.getCash() + 50);
                save(userData);
        }
    }

    public void updateThieving(String username, String thieving) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (thieving){
            case "paper":
                userData.setCash(userData.getCash() + 5);
                save(userData);
            case "watch":
                userData.setCash(userData.getCash() + 20);
                save(userData);
            case "phone":
                userData.setCash(userData.getCash() + 50);
                save(userData);
        }
    }

    private void save(UserData userData) {
        userDataRepository.save(userData);
    }
}
