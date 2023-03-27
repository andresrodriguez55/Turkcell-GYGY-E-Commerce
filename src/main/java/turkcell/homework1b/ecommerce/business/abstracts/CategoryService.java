package turkcell.homework1b.ecommerce.business.abstracts;

import org.springframework.stereotype.Service;
import turkcell.homework1b.ecommerce.entities.Category;
import turkcell.homework1b.ecommerce.entities.Product;

import java.util.List;

@Service
public interface CategoryService
{
    List<Category> getAll();

    Category create(Category category);

}
