package turkcell.homework1b.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.Product;
import turkcell.homework1b.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService
{
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id)
    {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product create(Product product)
    {
        validateProduct(product);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product update(int id, Product product)
    {
        validateProduct(product);
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Integer id)
    {
        Product dbProduct = productRepository.findById(id).orElseThrow();
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
