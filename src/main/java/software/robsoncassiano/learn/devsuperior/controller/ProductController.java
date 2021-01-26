package software.robsoncassiano.learn.devsuperior.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import software.robsoncassiano.learn.devsuperior.dto.ProductDTO;
import software.robsoncassiano.learn.devsuperior.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
  final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<ProductDTO>> findAll() {
    final List<ProductDTO> allProducts = productService.findAll();
    return ResponseEntity.ok().body(allProducts);
  }
}
