package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.pojo.UserDataDto;
import ee.taltech.twentyonebackend.pojo.UserInventoryDto;
import ee.taltech.twentyonebackend.pojo.response.InventoryResponse;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Resource
    UserInventoryService userInventoryService;

    @PostMapping
    public void fillDataResponse(String username) {
        UserInventoryDto userInventoryDto = userInventoryService.getByUsername(username);
        InventoryResponse inventoryResponse = new InventoryResponse(userInventoryDto);
    }

}
