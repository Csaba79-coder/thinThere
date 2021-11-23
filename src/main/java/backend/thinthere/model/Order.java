package backend.thinthere.model;

import backend.thinthere.enums.Status;
import backend.thinthere.enums.TypeOfPayment;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

  @OneToMany(mappedBy = "order") // other side!!! ...
  @JsonManagedReference(value = "order-products")
  private List<Product> product; // this needs foreign key

  @Enumerated(EnumType.STRING)
  private Status status;

  @Enumerated(EnumType.STRING)
  private TypeOfPayment typeOfPayment;

  private double totalPrice = totalPriceSum();

  public Order() {
  }

  private double totalPriceSum(){

    double currentTotalPrice = 0;

    if(product != null) {
      for (Product value : product) {
        currentTotalPrice += value.getUnitPrice();
      }
    }

    return currentTotalPrice;
  }

  public Order(Long id, User user, List<Product> product, Status status,
      TypeOfPayment typeOfPayment) {
    Id = id;
    this.user = user;
    this.product = product;
    this.status = status;
    this.typeOfPayment = typeOfPayment;
  }
}