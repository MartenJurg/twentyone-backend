package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.UserDataService;
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

    public boolean authenticateSkill(String username, String skillName){
        makeSkillDataDict();
        UserDataDto userDataDto = userDataService.getByUsername(username);
        return userDataDto.getCooking() >= skillData.get(skillName);
    }
}
