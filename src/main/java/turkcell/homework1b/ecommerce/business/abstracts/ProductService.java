package turkcell.homework1b.ecommerce.business.abstracts;

import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.entities.Product;

import java.util.List;

@Service
public interface ProductService
{
    List<Product> getAll();
    Product getById(int id);
    Product create(Product product);
    Product update(int id, Product product);
    void delete(Integer id);
}
