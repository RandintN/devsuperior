package software.robsoncassiano.learn.devsuperior.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import software.robsoncassiano.learn.devsuperior.dto.OrderDTO;
import software.robsoncassiano.learn.devsuperior.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping
  public ResponseEntity<List<OrderDTO>> findAll() {
    final List<OrderDTO> orderList = orderService.getAll();
    return ResponseEntity.ok().body(orderList);
  }

  @PostMapping
  public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderDTO orderDTO) {
    orderDTO = orderService.insertOrder(orderDTO);
    final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(orderDTO);
  }

}
