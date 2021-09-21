package com.xma.springbootproduction;

import com.xma.springbootproduction.controllers.Controller;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Smoke and Sanity Testing
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootProductionApplicationTests {

    @Autowired
    Controller controller;

    @Test
    void contextLoads() {
        Assert.assertNotNull(controller);
    }

}
