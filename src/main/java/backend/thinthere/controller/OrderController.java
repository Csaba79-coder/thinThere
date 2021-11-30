package backend.thinthere.controller;

import backend.thinthere.enums.Category;
import backend.thinthere.enums.Status;
import backend.thinthere.model.Order;
import backend.thinthere.model.Product;
import backend.thinthere.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
