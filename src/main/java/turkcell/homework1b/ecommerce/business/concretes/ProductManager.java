package turkcell.homework1b.ecommerce.business.concretes;

import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.concretes.Product;
import turkcell.homework1b.ecommerce.repository.abstracts.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager implements ProductService
{
    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll()
    {
        List<Product> products = productRepository.getAll();
        return products;
    }

    @Override
    public Product getById(Integer id)
    {
        Product product = productRepository.getById(id);
        if(product == null)
            throw new RuntimeException("Product does not exist...");
        return product;
    }

    @Override
    public void create(Product product)
    {
        if(product.getPrice() <= 0)
            throw new RuntimeException("Price value must be positive!");
        if(product.getQuantity() < 0)
            throw new RuntimeException("Quantity value must be equal to or bigger than 0!");
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new RuntimeException("Description length must be between 10 and 50!");
        productRepository.create(product);
    }

    @Override
    public void update(Product product)
    {
        if(product.getPrice() <= 0)
            throw new RuntimeException("Price value must be positive!");
        if(product.getQuantity() < 0)
            throw new RuntimeException("Quantity value must be equal to or bigger than 0!");
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new RuntimeException("Description length must be between 10 and 50!");
        productRepository.update(product);
    }

    @Override
    public void delete(Integer id)
    {
        Product dbProduct = productRepository.getById(id);
        if(dbProduct == null)
            throw new RuntimeException("Product not exists!");
        productRepository.delete(dbProduct);
    }
}
