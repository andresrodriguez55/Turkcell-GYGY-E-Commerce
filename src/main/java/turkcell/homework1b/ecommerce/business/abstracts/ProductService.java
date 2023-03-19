package turkcell.homework1b.ecommerce.business.abstracts;

import turkcell.homework1b.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductService
{
    List<Product> getAll();
    Product getById(int id);
    Product create(Product product);
    Product update(int id, Product product);
    void delete(Integer id);
}
