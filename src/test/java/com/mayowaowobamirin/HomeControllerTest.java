package com.mayowaowobamirin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testIndexRoute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"status\":\"success\",\"message\":\"Hello World\"}")));
    }

    @Test
    public void testMessagesPostRoute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/messages").contentType(MediaType.APPLICATION_JSON).content("{\"status\":\"success\",\"message\":\"Hello World\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"status\":\"success\",\"message\":\"Hello World\"}")));
    }
}
