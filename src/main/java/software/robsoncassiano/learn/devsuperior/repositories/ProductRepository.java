package software.robsoncassiano.learn.devsuperior.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.robsoncassiano.learn.devsuperior.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAllByOrderByNameAsc();
}
