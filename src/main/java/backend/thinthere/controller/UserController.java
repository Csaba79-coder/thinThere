package backend.thinthere.controller;

import backend.thinthere.config.JwtUtil;
import backend.thinthere.model.User;
import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.model.dto.LoginSuccessDTO;
import backend.thinthere.model.dto.UserRequestDTO;
import backend.thinthere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

  @GetMapping("/loggedinusers")
  public User getLoggedIn(){
    return userService.getLoggedInUser();
  }

}
