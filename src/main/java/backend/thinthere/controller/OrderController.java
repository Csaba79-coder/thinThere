package backend.thinthere.controller;

import backend.thinthere.service.OrderService;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

}
