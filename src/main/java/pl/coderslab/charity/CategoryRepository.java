package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.encje.Category;
import pl.coderslab.charity.encje.Institution;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByIdIn(List<Long> ids);


}
