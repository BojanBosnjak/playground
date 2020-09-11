package naprimer.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import naprimer.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	@Query("select c from Company c where c.name = name")
	Optional<Company> findByName(String name);

}
