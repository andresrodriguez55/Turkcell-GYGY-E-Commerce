package turkcell.homework1b.ecommerce.repository.concretes;

import org.springframework.stereotype.Repository;
import turkcell.homework1b.ecommerce.entities.concretes.Product;
import turkcell.homework1b.ecommerce.repository.abstracts.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository
{
    private List<Product> products;

    public InMemoryProductRepository()
    {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 13", 3, 60000, "apple phone"));
        products.add(new Product(2, "Samsung A7", 1, 12600, "samsung phone"));
        products.add(new Product(3, "Xiaomi 57P", 2, 320000, "Xiaomi phone"));
        products.add(new Product(4, "Iphone 12", 5, 50000, "Apple phone"));
    }

    @Override
    public Product getById(Integer id)
    {
        for(Product dbProduct : products)
        {
            if(dbProduct.getId().equals(id))
            {
                return dbProduct;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll()
    {
        return products;
    }

    @Override
    public void create(Product product)
    {
        products.add(product);
    }

    @Override
    public void delete(Product product)
    {
        for(int x=0; x<products.size(); x++)
        {
            Product dbProduct = products.get(x);
            if(dbProduct.getId().equals(product.getId()))
            {
                products.remove(x);
                return;
            }
        }
    }

    @Override
    public void update(Product product)
    {
        for(int x=0; x<products.size(); x++)
        {
            Product productDb = products.get(x);
            if(product.getId().equals(productDb.getId()))
            {
                products.set(x, product);
                return;
            }
        }
    }
}
