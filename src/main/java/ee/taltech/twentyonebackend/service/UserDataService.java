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
        switch (dish) {
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

    public void updateBeverage(String username, String beverage) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        switch (beverage) {
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
        userData.setStrenghtxp(userData.getStrenghtxp() + 2);
        userData.setStrenght(userData.getStrenghtxp() / 50);
        saveData(userData);
    }

    public void updateDefence(String username) {
        UserData userData = userDataRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
        userData.setDefencexp(userData.getDefencexp() + 2);
        userData.setDefence(userData.getDefencexp() / 50);
        saveData(userData);
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
}