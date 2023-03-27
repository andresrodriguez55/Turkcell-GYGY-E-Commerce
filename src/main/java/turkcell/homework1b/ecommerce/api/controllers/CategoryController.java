package turkcell.homework1b.ecommerce.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcell.homework1b.ecommerce.business.abstracts.CategoryService;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.Category;
import turkcell.homework1b.ecommerce.entities.Product;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories")
@AllArgsConstructor
public class CategoryController
{
    private final CategoryService service;

    @GetMapping
    public List<Category> getAll()
    {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody Category category)
    {
        return service.create(category);
    }

}
