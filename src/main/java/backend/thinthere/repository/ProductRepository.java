package backend.thinthere.repository;

import backend.thinthere.enums.Category;
import backend.thinthere.model.Product;
import backend.thinthere.model.TypeOfProduct;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findById(Long Id);

  Optional<Product> findByProductName(String name);

  List<Product> findAll();

  List<Product> findByCategory(Category category);

  List<Product> findByTypeOfProductList(TypeOfProduct typeOfProduct);

}
