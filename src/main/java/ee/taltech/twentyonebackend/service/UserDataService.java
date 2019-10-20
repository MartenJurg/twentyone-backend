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
                break;
            case "pasta":
                userData.setCash(userData.getCash() + 20);
                save(userData);
                break;
            case "duck":
                userData.setCash(userData.getCash() + 50);
                save(userData);
                break;
        }
    }

    public void updateCrafting(String username, String craft) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (craft){
            case "gloves":
                userData.setCash(userData.getCash() + 5);
                save(userData);
                break;
            case "hat":
                userData.setCash(userData.getCash() + 20);
                save(userData);
                break;
            case "sweater":
                userData.setCash(userData.getCash() + 50);
                save(userData);
                break;
        }
    }

    public void updateBeverage(String username, String beverage) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (beverage){
            case "water":
                userData.setCash(userData.getCash() + 5);
                save(userData);
                break;
            case "applejuice":
                userData.setCash(userData.getCash() + 20);
                save(userData);
                break;
            case "gintonic":
                userData.setCash(userData.getCash() + 50);
                save(userData);
                break;
        }
    }

    public void updateThieving(String username, String thieving) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (thieving){
            case "paper":
                userData.setCash(userData.getCash() + 5);
                save(userData);
                break;
            case "watch":
                userData.setCash(userData.getCash() + 20);
                save(userData);
                break;
            case "phone":
                userData.setCash(userData.getCash() + 50);
                save(userData);
                break;
        }
    }

    public void save(UserData userData) {
        userDataRepository.save(userData);
    }
}
