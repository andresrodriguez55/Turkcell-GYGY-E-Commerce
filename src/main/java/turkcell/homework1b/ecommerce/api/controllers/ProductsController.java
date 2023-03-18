package turkcell.homework1b.ecommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.concretes.Product;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductsController
{
    private ProductService service;

    @Autowired
    public ProductsController(ProductService service)
    {
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public Product getById(@PathVariable("id") Integer id)
    {
        return service.getById(id);
    }

    @GetMapping(path = "/")
    public List<Product> getAll()
    {
        return service.getAll();
    }

    @PostMapping(path = "/")
    public void create(@RequestBody Product product)
    {
        service.create(product);
    }

    @PutMapping(path = "/")
    public void update(Product product)
    {
        service.update(product);
    }

    @DeleteMapping(path="{id}")
    public void remove(@PathVariable("id") Integer id)
    {
        service.delete(id);
    }
}
