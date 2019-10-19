package ee.taltech.twentyonebackend.controller;


import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.CookForm;
import ee.taltech.twentyonebackend.pojo.request.CraftForm;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/crafting")
public class CraftingController {

    @Resource
    DataAuthenticator dataAuthenticator;

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/craft")
    public ResponseEntity<?> authenticateUser(@RequestBody CraftForm craftForm) {
        if (!dataAuthenticator.authenticateSkill(craftForm.getUsername(), craftForm.getCraft())) {
            throw new ValidationException();
        }

        updateGameData.craft(craftForm.getUsername(), craftForm.getCraft());

        return ResponseEntity.ok(new ResponseMessage("Craft was made"));
    }
}