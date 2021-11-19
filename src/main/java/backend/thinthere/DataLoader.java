package backend.thinthere;

import backend.thinthere.config.SecurityConfig;
import backend.thinthere.enums.Role;
import backend.thinthere.model.User;
import backend.thinthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;


  public DataLoader(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void run(ApplicationArguments arguments) {

    userRepository.save(new User("jucus@gmail.com", "Juci", "Muci", passwordEncoder.encode("pass"), "CsodaOrszág", "7", "NégyszögletűKerekerdő", "Óperencia utca", "666", "123456789"));

  }

}
