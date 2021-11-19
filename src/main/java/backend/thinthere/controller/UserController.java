package backend.thinthere.controller;

import backend.thinthere.model.dto.LoginRequestDTO;
import backend.thinthere.model.dto.LoginSuccessDTO;
import backend.thinthere.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
