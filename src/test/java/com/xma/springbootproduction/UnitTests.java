package com.xma.springbootproduction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xma.springbootproduction.controllers.Controller;

import com.xma.springbootproduction.models.Message;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


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
    public void testGetMsg() throws Exception {
        mockMvc.perform(get("/api/message")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("first message")));
    }

    @Test
    public void testGetSay() throws Exception {
        mockMvc.perform(get("/api/helloworld")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(post("/api/message")
                        .content(asJsonString(new Message("post test msg")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("post test msg")));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
