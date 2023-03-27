package turkcell.homework1b.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.business.abstracts.CategoryService;
import turkcell.homework1b.ecommerce.business.abstracts.ProductService;
import turkcell.homework1b.ecommerce.entities.Category;
import turkcell.homework1b.ecommerce.entities.Product;
import turkcell.homework1b.ecommerce.repository.CategoryRepository;
import turkcell.homework1b.ecommerce.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService
{
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll()
    {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category)
    {
        categoryRepository.save(category);
        return category;
    }

}
