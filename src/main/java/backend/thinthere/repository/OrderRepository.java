package backend.thinthere.repository;

import backend.thinthere.model.Order;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
