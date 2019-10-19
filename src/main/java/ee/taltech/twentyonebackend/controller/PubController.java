package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.BeverageForm;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pub")
public class PubController {

    @Resource
    DataAuthenticator dataAuthenticator;

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/serve")
    public ResponseEntity<?> authenticateUser(@RequestBody BeverageForm beverageForm) {
        if (!dataAuthenticator.authenticateSkill(beverageForm.getUsername(), beverageForm.getBeverage())) {
            throw new ValidationException();
        }

        updateGameData.cook(beverageForm.getUsername(), beverageForm.getBeverage());

        return ResponseEntity.ok(new ResponseMessage("Beverage was made and served!"));
    }
}