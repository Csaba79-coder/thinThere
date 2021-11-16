package backend.thinthere.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  private User user;

  @OneToMany(mappedBy = "order")
  @JsonManagedReference(value = "order-products")
  private List<Product> product;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Enumerated(EnumType.STRING)
  private Payment payment;

  private double totalPrice = totalPriceSum();

  public Order() {
  }

  private double totalPriceSum(){

    double currentTotalPrice = 0;

    for (int i = 0; i < product.size(); i++) {
      currentTotalPrice =+ product.get(i).getUnitPrice();
    }

    return currentTotalPrice;
  }

}
