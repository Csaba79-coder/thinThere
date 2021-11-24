package backend.thinthere.repository;

import backend.thinthere.model.Order;
import backend.thinthere.model.Product;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  Optional<Order> findById(Long Id);

}
