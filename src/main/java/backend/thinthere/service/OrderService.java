package backend.thinthere.service;

import backend.thinthere.enums.Status;
import backend.thinthere.model.Order;
import backend.thinthere.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> getAllOrder() {
    return orderRepository.findAll();
  }

  public List<Order> findOrderByStatus(Status status) {
    return orderRepository.findByStatus(status);
  }

  // TODO check what optional does or needs throws Exception
  public Optional<Order> findOrderById(Long Id) {
    return orderRepository.findById(Id);
  }

  public Optional<Order> findOrderByUser(String username) {
    return orderRepository.findByUser(username);
  }
}
