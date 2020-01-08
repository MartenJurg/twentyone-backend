package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.pojo.RoleNames;
import ee.taltech.twentyonebackend.pojo.UserInventoryDto;
import ee.taltech.twentyonebackend.pojo.response.InventoryResponse;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/inventory")
@Secured({RoleNames.ROLE_ADMIN, RoleNames.ROLE_USER})
public class InventoryController {

    @Resource
    UserInventoryService userInventoryService;

    @PostMapping
    public ResponseEntity<?> fillDataResponse(@RequestBody String username) {
        UserInventoryDto userInventoryDto = userInventoryService.getByUsername(username);
        InventoryResponse inventoryResponse = new InventoryResponse(userInventoryDto);
        return ResponseEntity.ok(inventoryResponse);
    }

}
