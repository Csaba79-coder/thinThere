package backend.thinthere.controller;

import backend.thinthere.config.SecurityConfigTest;
import backend.thinthere.enums.Category;
import backend.thinthere.model.Product;
import backend.thinthere.model.TypeOfProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SecurityConfigTest.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    Product dummyProduct = new Product();

    /*public Product setDummyProduct(Product dummyProduct) {
        this.dummyProduct = dummyProduct;

        Set<TypeOfProduct> typeList = new HashSet<>();
        typeList.add(new TypeOfProduct("GLUTEN_FREE"));

        dummyProduct.setId(1L);
        dummyProduct.setCategory(Category.SPORTS_EQUIPMENT);
        dummyProduct.setTypeOfProductList(typeList);
        dummyProduct.setProductName("Yoga Ball");
        return dummyProduct;
    }*/

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProduct() {
        try {
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //can see with login
    @Test
    @WithUserDetails("admin@admin.com")
    void getProductById() throws Exception {
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getProductByCategory() throws Exception {
        mockMvc.perform(get("/products/category/SPORTS_EQUIPMENT"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithUserDetails("admin@admin.com")
    void getProductByType() throws Exception {
        Set<TypeOfProduct> typeOfProductList = new HashSet<>();
        typeOfProductList.add(new TypeOfProduct("GLUTEN_FREE"));

        mockMvc.perform(get("/products/type_of_product/GLUTEN_FREE"))
                .andExpect(status().is(400))
                .andReturn();

        }

    @Test
    @WithUserDetails("admin@admin.com")
    void getProductByName() throws Exception {
        mockMvc.perform(get("/products/name/Yoga Ball"))
                .andExpect(status().isOk())
                .andReturn();
    }

}