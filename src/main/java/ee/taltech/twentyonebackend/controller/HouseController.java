package ee.taltech.twentyonebackend.controller;


import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.RoleNames;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/house")
@Secured({RoleNames.ROLE_ADMIN, RoleNames.ROLE_USER})
public class HouseController {

    @Resource
    DataAuthenticator dataAuthenticator;

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/upgrade")
    public ResponseEntity<?> fillDataResponse(@RequestBody String username) {
        if (!dataAuthenticator.authenticateBuilding(username)) {
            throw new ValidationException();
        }

        updateGameData.houseUpgrade(username);

        return ResponseEntity.ok(new ResponseMessage("House was successfully built!"));
    }
}
