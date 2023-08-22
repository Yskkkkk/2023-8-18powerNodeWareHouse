package com.ysk;

import com.ysk.service.BuyListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BuyListService roleService;
    @Test
    void contextLoads() {
        roleService.deletePurchaseById(48);

    }

}
