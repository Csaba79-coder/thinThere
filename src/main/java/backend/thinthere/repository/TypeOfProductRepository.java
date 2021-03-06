package backend.thinthere.repository;

import backend.thinthere.model.TypeOfProduct;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfProductRepository extends JpaRepository<TypeOfProduct, String> {

  Optional<TypeOfProduct> findByName(String name);

}
