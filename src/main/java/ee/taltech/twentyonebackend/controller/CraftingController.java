package ee.taltech.twentyonebackend.controller;


import ee.taltech.twentyonebackend.exception.ValidationException;
import ee.taltech.twentyonebackend.pojo.DataAuthenticator;
import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.SkillForm;
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
    public ResponseEntity<?> authenticateUser(@RequestBody SkillForm skillForm) {
        if (!dataAuthenticator.authenticateSkill(skillForm.getUsername(), skillForm.getSkill())) {
            throw new ValidationException();
        }

        updateGameData.craft(skillForm.getUsername(), skillForm.getSkill());

        return ResponseEntity.ok(new ResponseMessage("Craft was made"));
    }

    @PostMapping("/sell")
    public ResponseEntity<?> sellCrafts(@RequestBody String username) {

        updateGameData.sellCrafts(username);

        return ResponseEntity.ok(new ResponseMessage("Crafts were sold"));
    }
}
