package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.pojo.UserDataDto;
import ee.taltech.twentyonebackend.pojo.response.DataResponse;
import ee.taltech.twentyonebackend.service.UserDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
public class DataController {

    @Resource
    UserDataService userDataService;

    @PostMapping
    public DataResponse fillDataResponse(String username) {
        UserDataDto userDataDto = userDataService.getByUsername(username);
        DataResponse dataResponse = new DataResponse(userDataDto);
        return dataResponse;
    }

}
