package naprimer.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import naprimer.demo.entity.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	Optional<Facility> findByName (String name);
	Optional<Facility> findById(Integer id);
	
	@Query("select f from Facility f where f.company.companyId=:companyId")
	List<Facility> getCompanyFacilities(Integer companyId);
	
}
