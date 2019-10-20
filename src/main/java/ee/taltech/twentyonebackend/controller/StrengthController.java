package ee.taltech.twentyonebackend.controller;


import ee.taltech.twentyonebackend.pojo.UpdateGameData;
import ee.taltech.twentyonebackend.pojo.request.SkillForm;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/boxing")
public class StrengthController {

    @Resource
    UpdateGameData updateGameData;

    @PostMapping("/strength")
    public ResponseEntity<?> authenticateUser(@RequestBody SkillForm skillForm) {

        updateGameData.trainStrength(skillForm.getUsername());

        return ResponseEntity.ok(new ResponseMessage("Gained more strength"));
    }
}
