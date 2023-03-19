package turkcell.homework1b.ecommerce.repository.abstracts;

import turkcell.homework1b.ecommerce.entities.concretes.Product;

import java.util.List;

public interface ProductRepository
{
    Product getById(int id);
    List<Product> getAll();
    Product create(Product product);
    Product update(int id, Product product);
    void delete(Product product);
}
