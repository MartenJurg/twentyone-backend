package ee.taltech.twentyonebackend.controller;


import ee.taltech.twentyonebackend.pojo.RoleNames;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/boxing")
@Secured({RoleNames.ROLE_ADMIN, RoleNames.ROLE_USER})
public class BoxingController {

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/defence")
    public ResponseEntity<?> authenticateDefence(@RequestBody String username) {

        updateGameData.trainDefence(username);

        return ResponseEntity.ok(new ResponseMessage("Gained more defence"));
    }

    @PostMapping("/strength")
    public ResponseEntity<?> authenticateStrength(@RequestBody String username) {

        updateGameData.trainStrength(username);

        return ResponseEntity.ok(new ResponseMessage("Gained more strength"));
    }
}
