package backend.thinthere.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long Id;

  User user;

  @ManyToMany(mappedBy = "order")
  @JsonManagedReference(value = "order-products")
  List<Products> products;

  @Enumerated(EnumType.STRING)
  Status status;

  @Enumerated(EnumType.STRING)
  Payment payment;

  double totalPrice = totalPriceSum();

  public Order() {
  }

  public double totalPriceSum(){

    double currentTotalPrice = 0;

    for (int i = 0; i < products.size(); i++) {
      currentTotalPrice = currentTotalPrice + products.get(i).getUnitPrice();
    }

    return currentTotalPrice;
  }

}
