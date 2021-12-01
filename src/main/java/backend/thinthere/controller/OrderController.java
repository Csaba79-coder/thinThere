package backend.thinthere.controller;

import backend.thinthere.enums.Status;
import backend.thinthere.model.Order;
import backend.thinthere.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/orders")
  public List<Order> getAllOrder(){
    return orderService.findAllOrder();
  }

  @GetMapping("/orders/{id}")
  public Optional<Order> getOrderById(@PathVariable("id") Long id) {
    return orderService.findById(id);
  }

  @GetMapping("/orders/{status}")
  public List<Order> getOrderByStatus(@PathVariable("status") Status status) {
    return orderService.findOrderByStatus(status);
  }

/*  @PostMapping("/orders")
  public Order addNewOrder(@RequestBody Order order) {
    Order newOrder =
            new Order(
            order.getUser(),
            order.getProduct(),
            order.getStatus(),
            order.getTypeOfPayment());
    return orderService.saveNewOrder(newOrder);
  }*/

  @PutMapping("/orders/{id}")
  public Order updateOrderById(@PathVariable("id") Long id,
                                         @RequestBody Order order) {
    Order orderData = orderService.findById(id).orElseThrow();

    try {
        orderData.setUser(order.getUser());
        orderData.setProduct(order.getProduct());
        orderData.setStatus(order.getStatus());
        orderData.setTypeOfPayment(order.getTypeOfPayment());
      } catch (Exception e) {
        e.printStackTrace();
      }

    return orderService.updateOrder(orderData);
  }

  @DeleteMapping("/orders/{id}")
  public void deleteOrder(@PathVariable("id") long id) {
    orderService.deleteOrder(id);
  }

}
