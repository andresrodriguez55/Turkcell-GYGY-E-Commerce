package turkcell.homework1b.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turkcell.homework1b.ecommerce.entities.Category;
import turkcell.homework1b.ecommerce.entities.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
