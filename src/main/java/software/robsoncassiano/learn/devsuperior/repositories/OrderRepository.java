package software.robsoncassiano.learn.devsuperior.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import software.robsoncassiano.learn.devsuperior.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.productSet WHERE obj.status = 0 " +
      "ORDER BY obj.moment ASC")
  List<Order> findOrdersWithProducts();
}
