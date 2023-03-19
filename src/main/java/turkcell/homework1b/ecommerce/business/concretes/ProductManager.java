package turkcell.homework1b.ecommerce.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.concretes.Product;
import turkcell.homework1b.ecommerce.repository.abstracts.ProductRepository;

import java.util.List;

@Service
public class ProductManager implements ProductService
{
    private final ProductRepository productRepository;

    @Autowired
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
    public Product getById(int id)
    {
        Product product = productRepository.getById(id);
        if(product == null)
            throw new RuntimeException("Product does not exist...");
        return product;
    }

    @Override
    public Product create(Product product)
    {
        validateProduct(product);

        productRepository.create(product);
        return product;
    }

    @Override
    public Product update(int id, Product product)
    {
        validateProduct(product);

        productRepository.update(id, product);
        return product;
    }

    @Override
    public void delete(Integer id)
    {
        Product dbProduct = productRepository.getById(id);
        if(dbProduct == null)
            throw new RuntimeException("Product not exists!");

        productRepository.delete(dbProduct);
    }

    // Business Rules
    private void validateProduct(Product product)
    {
        checkIfUnitPriceIsValid(product);
        checkIfQuantityIsValid(product);
        checkIfDescriptionLengthIsValid(product);
    }

    private void checkIfUnitPriceIsValid(Product product)
    {
        if(product.getUnitPrice() <= 0)
            throw new IllegalArgumentException("Price value must be positive!");
    }

    private void checkIfQuantityIsValid(Product product)
    {
        if(product.getQuantity() < 0)
            throw new IllegalArgumentException("Quantity value must be equal to or bigger than 0!");
    }

    private void checkIfDescriptionLengthIsValid(Product product)
    {
        if(product.getDescription().length() < 10 || product.getDescription().length() > 50)
            throw new IllegalArgumentException("Description length must be between 10 and 50!");
    }
}
