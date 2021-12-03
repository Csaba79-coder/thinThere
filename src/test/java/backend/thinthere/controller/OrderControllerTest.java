package backend.thinthere.controller;

import backend.thinthere.config.SecurityConfigTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SecurityConfigTest.class)
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllOrder() {
        try {
            mockMvc.perform(get("/orders"))
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getInvalidEndpoint() throws Exception {
        mockMvc.perform(get("/invalid-end-point"))
                .andExpect(status().is(404))
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getOrderById() throws Exception {
        mockMvc.perform(get("/orders/12"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getOrderByStatus() throws Exception {
        mockMvc.perform(get("/orders/status/ORDERED"))
                .andExpect(status().isOk())
                .andReturn();
    }

}