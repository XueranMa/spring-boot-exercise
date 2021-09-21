package com.xma.springbootproduction;

import com.xma.springbootproduction.controllers.Controller;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


// Test Standalone Controller
// Mock neccessary services
// Using Mockito if neccessary
// When(call).thenReturn(mock)

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class UnitTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .get("/message")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0]", Matchers.is("first message")))
    }

}
