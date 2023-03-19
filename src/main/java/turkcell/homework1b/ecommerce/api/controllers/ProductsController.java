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
    public Product create(@RequestBody Product product)
    {
        return service.create(product);
    }

    @PutMapping(path = "{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product)
    {
        return service.update(id, product);
    }

    @DeleteMapping(path="{id}")
    public void remove(@PathVariable("id") Integer id)
    {
        service.delete(id);
    }
}
