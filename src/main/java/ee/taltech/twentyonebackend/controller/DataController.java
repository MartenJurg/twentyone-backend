package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.pojo.RoleNames;
import ee.taltech.twentyonebackend.pojo.UserDataDto;
import ee.taltech.twentyonebackend.pojo.response.DataResponse;
import ee.taltech.twentyonebackend.service.UserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/data")
@Secured({RoleNames.ROLE_ADMIN, RoleNames.ROLE_USER})
public class DataController {

    @Resource
    UserDataService userDataService;

    @PostMapping("/data")
    public ResponseEntity<?> fillDataResponse(@RequestBody String username) {
        UserDataDto userDataDto = userDataService.getByUsername(username);
        DataResponse dataResponse = new DataResponse(userDataDto);
        return ResponseEntity.ok(dataResponse);
    }

}
