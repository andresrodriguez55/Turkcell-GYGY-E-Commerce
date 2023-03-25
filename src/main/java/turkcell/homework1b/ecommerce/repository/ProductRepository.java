package turkcell.homework1b.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turkcell.homework1b.ecommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
