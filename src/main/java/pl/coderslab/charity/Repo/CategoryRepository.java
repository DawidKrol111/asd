package pl.coderslab.charity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.Entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByIdIn(List<Long> ids);


}
