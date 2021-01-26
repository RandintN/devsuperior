package software.robsoncassiano.learn.devsuperior.dto;

import java.io.Serializable;
import software.robsoncassiano.learn.devsuperior.entities.Product;

public class ProductDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private long id;
  private String name;
  private Double price;
  private String description;
  private String imageUri;

  public ProductDTO() {
  }

  public ProductDTO(long id, String name, Double price, String description, String imageUri) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageUri = imageUri;
  }

  public ProductDTO(Product entity) {
    id = entity.getId();
    name = entity.getName();
    price = entity.getPrice();
    description = entity.getDescription();
    imageUri = entity.getImageUri();
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public String getImageUri() {
    return imageUri;
  }

}
