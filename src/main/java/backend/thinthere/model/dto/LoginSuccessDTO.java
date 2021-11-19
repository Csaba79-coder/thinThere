package backend.thinthere.model.dto;

import lombok.Getter;

@Getter
public class LoginSuccessDTO {

  private final String status;
  private final String token;

  public LoginSuccessDTO(String jwt) { // jwt -->> json web token
    this.status = "OK";
    this.token = jwt;
  }

}
