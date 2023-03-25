package turkcell.homework1b.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.Product;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
@AllArgsConstructor
public class ProductsController
{
    private final ProductService service;

    @GetMapping(path = "/{id}")
    public Product getById(@PathVariable("id") Integer id)
    {
        return service.getById(id);
    }

    @GetMapping
    public List<Product> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product)
    {
        return service.create(product);
    }

    @PutMapping(path = "/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product)
    {
        return service.update(id, product);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Integer id)
    {
        service.delete(id);
    }
}
