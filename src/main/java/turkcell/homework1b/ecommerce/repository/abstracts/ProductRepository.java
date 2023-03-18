package turkcell.homework1b.ecommerce.repository.abstracts;

import turkcell.homework1b.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository
{
    Product getById(Integer id);
    List<Product> getAll();
    void create(Product product);
    void delete(Product product);
    void update(Product product);
}
