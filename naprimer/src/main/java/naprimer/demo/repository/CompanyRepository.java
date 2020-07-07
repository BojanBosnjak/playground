package naprimer.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import naprimer.demo.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Optional<Company> findByName(String name);

}
