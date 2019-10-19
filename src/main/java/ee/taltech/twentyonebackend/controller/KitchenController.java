package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.CookForm;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import ee.taltech.twentyonebackend.service.UserDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Resource
    DataAuthenticator dataAuthenticator;

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/cook")
    public ResponseEntity<?> authenticateUser(@RequestBody CookForm cookForm) {
        if (!dataAuthenticator.authenticateSkill(cookForm.getUsername(), cookForm.getDish())) {
            throw new ValidationException();
        }

        updateGameData.cook(cookForm.getUsername(), cookForm.getDish());

        return ResponseEntity.ok(new ResponseMessage("Dish was made and served!"));
    }


}