package software.robsoncassiano.learn.devsuperior.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import software.robsoncassiano.learn.devsuperior.entities.Order;
import software.robsoncassiano.learn.devsuperior.entities.OrderStatus;

public class OrderDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String address;
  private Double latitude;
  private Double longitude;
  private Instant moment;
  private OrderStatus status;

  private List<ProductDTO> products = new ArrayList<>();

  public OrderDTO(Long id,
                  String address,
                  Double latitude,
                  Double longitude,
                  Instant moment,
                  OrderStatus status) {
    this.id = id;
    this.address = address;
    this.latitude = latitude;
    this.longitude = longitude;
    this.moment = moment;
    this.status = status;
  }

  public OrderDTO(Order entity) {
    id = entity.getId();
    this.address = entity.getAddress();
    this.latitude = entity.getLatitude();
    this.longitude = entity.getLongitude();
    this.moment = entity.getMoment();
    this.status = entity.getStatus();
    this.products = entity.getProductSet().stream().map(ProductDTO::new).collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public String getAddress() {
    return address;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Instant getMoment() {
    return moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public List<ProductDTO> getProducts() {
    return products;
  }
}
