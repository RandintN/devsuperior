package software.robsoncassiano.learn.devsuperior.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.robsoncassiano.learn.devsuperior.dto.OrderDTO;
import software.robsoncassiano.learn.devsuperior.dto.ProductDTO;
import software.robsoncassiano.learn.devsuperior.entities.Order;
import software.robsoncassiano.learn.devsuperior.entities.OrderStatus;
import software.robsoncassiano.learn.devsuperior.entities.Product;
import software.robsoncassiano.learn.devsuperior.repositories.OrderRepository;
import software.robsoncassiano.learn.devsuperior.repositories.ProductRepository;

@Service
public class OrderService {
  final
  ProductRepository productRepository;

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
    this.orderRepository = orderRepository;
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public List<OrderDTO> getAll() {
    final List<Order> orderList = orderRepository.findOrdersWithProducts();
    return orderList.stream().map(OrderDTO::new).collect(Collectors.toList());
  }

  @Transactional
  public OrderDTO insertOrder(OrderDTO dto) {
    Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
          Instant.now(), OrderStatus.PENDING);
    for (ProductDTO eachProduct : dto.getProducts()) {
      Product product = productRepository.getOne(eachProduct.getId());
      order.getProductSet().add(product);
    }
    order = orderRepository.save(order);
    return new OrderDTO(order);
  }
}
