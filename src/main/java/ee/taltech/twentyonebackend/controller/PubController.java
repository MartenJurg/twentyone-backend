package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.RoleNames;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.SkillForm;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pub")
@Secured({RoleNames.ROLE_ADMIN, RoleNames.ROLE_USER})
public class PubController {

    @Resource
    DataAuthenticator dataAuthenticator;

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/serve")
    public ResponseEntity<?> authenticateUser(@RequestBody SkillForm skillForm) {
        if (!dataAuthenticator.authenticateBeverage(skillForm.getUsername(), skillForm.getSkill())) {
            throw new ValidationException();
        }

        updateGameData.beverage(skillForm.getUsername(), skillForm.getSkill());

        return ResponseEntity.ok(new ResponseMessage("Beverage was made and served!"));
    }
}