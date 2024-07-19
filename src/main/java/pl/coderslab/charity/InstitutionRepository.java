package pl.coderslab.charity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.encje.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

    @Query(value = "SELECT * FROM institution ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<Institution> findRandomInstitutions();

}
