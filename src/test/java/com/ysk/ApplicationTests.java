package com.ysk;

import com.ysk.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private RoleService roleService;
    @Test
    void contextLoads() {
        roleService.deleteRole(17);

    }

}
