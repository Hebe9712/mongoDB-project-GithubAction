package com.example.springboot_mongodb.controller;

import com.example.springboot_mongodb.domain.Owner;
import com.example.springboot_mongodb.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@WebMvcTest(controllers = OwnerController.class)
public class OwnerControllerTest {
    @MockBean
    private OwnerService ownerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_getOwnerById_success() throws Exception {
        Owner owner = new Owner("1", "Joey", new ArrayList<>());
        Mockito.when(ownerService.getOwnerById("1")).thenReturn(owner);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/owner/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(
                        "{\n" +
                                "    \"id\": \"1\",\n" +
                                "    \"name\": \"Joey\",\n" +
                                "    \"pets\": []\n" +
                                "}"));
    }
}
