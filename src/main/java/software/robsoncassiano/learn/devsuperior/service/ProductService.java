package software.robsoncassiano.learn.devsuperior.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.robsoncassiano.learn.devsuperior.dto.ProductDTO;
import software.robsoncassiano.learn.devsuperior.entities.Product;
import software.robsoncassiano.learn.devsuperior.repositories.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Transactional(readOnly = true)
  public List<ProductDTO> findAll() {
    final List<Product> productList = productRepository.findAllByOrderByNameAsc();
    return productList.stream().map(ProductDTO::new).collect(Collectors.toList());
  }

}
