package backend.thinthere.repository;

import backend.thinthere.model.Product;
import backend.thinthere.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findById(Long Id);

}
