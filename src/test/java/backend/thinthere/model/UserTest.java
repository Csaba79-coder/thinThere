package backend.thinthere.model;

import backend.thinthere.model.dto.UserRequestDTO;
import backend.thinthere.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserTest {

     @Autowired
     private UserService userService;


    @Test
    void createNewUserTest() throws Exception {

        UserRequestDTO user = new UserRequestDTO();

        user.setUsername("csabavadasz79@gmail.com");
        user.setFirstName("Csaba");
        user.setLastName("Vadász");
        user.setPassword("1234");
        user.setCountry("Hungary");
        user.setPostalCode("2011");
        user.setCity("Budakalász");
        user.setAddress("Gerinc");
        user.setHouseNumber("2287/3");
        user.setPhoneNumber("06-30-235-63-04");

        userService.register(user);

        assertEquals(4, userService.getAllUsers().size());

        assertEquals("csabavadasz79@gmail.com",
                userService.getUserByUsername("csabavadasz79@gmail.com").get().getUsername());
    }
}