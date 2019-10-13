package ee.taltech.twentyonebackend.service;


import ee.taltech.twentyonebackend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    RoleRepository roleRepository;
}
