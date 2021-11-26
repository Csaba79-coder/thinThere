package backend.thinthere.repository;

import backend.thinthere.model.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Optional<User> findByID(Long ID);

  List<User> findAll();

}
