package backend.thinthere.service;

import backend.thinthere.enums.Status;
import backend.thinthere.model.Order;
import backend.thinthere.model.Product;
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

  public Optional<Order> findById(Long Id) {
    return orderRepository.findById(Id);
  }

  /*public Optional<Order> findByName(String username) {
    return orderRepository.findByName(username);
  }*/

  public List<Order> findAllOrder() {
    return orderRepository.findAll();
  }

  public List<Order> findOrderByStatus(Status status) {
    return orderRepository.findByStatus(status);
  }

  /**
   * create, update, delete
   */

  /*
  public Order saveNewOrder(Order order) {
    return orderRepository.save(order);
  }

  public Order updateOrder(Order order, Long id) {
    return orderRepository.save(order);
  }

  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }
  */
}
