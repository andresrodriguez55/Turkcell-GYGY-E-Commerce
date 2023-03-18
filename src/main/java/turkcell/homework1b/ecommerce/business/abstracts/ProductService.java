package turkcell.homework1b.ecommerce.business.abstracts;

import turkcell.homework1b.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAll();
    Product getById(Integer id);
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
}
