package backend.thinthere.controller;

import backend.thinthere.model.User;
import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.model.dto.LoginSuccessDTO;
import backend.thinthere.model.dto.UserRequestDTO;
import backend.thinthere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginSuccessDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
    LoginSuccessDTO loginSuccessDTO = new LoginSuccessDTO(userService.authenticateExistingUser(loginRequestDTO));
    return ResponseEntity.status(HttpStatus.OK).body(loginSuccessDTO);
  }

  @PostMapping("/register")
  public ResponseEntity<Void> register(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
    userService.register(userRequestDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  //only logged in user can see
  @Secured("ADMIN")
  @PreAuthorize("hasAuthority('DELETE')")
  @GetMapping("/get")
  public String getHello() {
    return "hello";
  }

  @GetMapping("/loggedInUsers")
  public User getLoggedIn(){
    return userService.getLoggedInUser();
  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/users/{id}")
  public Optional<User> getUserById(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }


  @PutMapping("/users/{id}")
  public User updateUserById(@PathVariable("id") Long id,
                                             @RequestBody User user) {
    User userData = userService.getUserById(id).orElseThrow();

    try {
      userData.setUsername(user.getUsername());
      userData.setFirstName(user.getFirstName());
      userData.setLastName(user.getLastName());
      userData.setPassword(user.getPassword());
      userData.setCountry(user.getCountry());
      userData.setPostalCode(user.getPostalCode());
      userData.setCity(user.getCity());
      userData.setAddress(user.getAddress());
      userData.setHouseNumber(user.getHouseNumber());
      userData.setPhoneNumber(user.getPhoneNumber());
      userData.setOrder(user.getOrder());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return userService.updateUser(userData);
  }


  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
  }
}
