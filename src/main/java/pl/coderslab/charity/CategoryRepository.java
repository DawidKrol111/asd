package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.encje.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
