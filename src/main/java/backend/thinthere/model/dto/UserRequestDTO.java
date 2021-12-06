package backend.thinthere.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDTO {

  private String username;
  private String firstName;
  private String lastName;
  private String password;
  private String country;
  private String postalCode;
  private String city;
  private String address;
  private String houseNumber;
  private String phoneNumber;

}
