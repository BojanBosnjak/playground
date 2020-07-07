package naprimer.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import naprimer.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByName(String name);

	@Query("select e from Employee e where e.company.companyId=:companyId")
	List<Employee> getCompanyEmployees(Integer companyId);

	/*update authority metoda. Nad ovom metodom ce mogucnost ispravke imati Company
	 * Moze da bude employee sto je authority_id=2 ili editor sto je authority_id=5
	 * Editor moze da upravlja tekstom, opisom firme i da ubacuje neke fortke, da ubaci facility novi i tome slicno
	 */
	
	//kaze colak da ako radim preko entiteta ne treba mi query. Drugim recima mogu da radim preko entiteta
	@Modifying
	@Query("update Employee e set e.authority.id = ?2 where e.employeeId = ?1")
	void updateEmployeeAuthority(Integer employeeId, Integer authority);
	
	/*update employee company.
	 * OVO MOGU DA SREDIM PREKO REST API I SECURITY, da dam pristup company da radi ovaj update
	 * Company moze da uradi update na company_id u employee tabeli.
	 * Company moze da stavi samo svoj company_id u employee
	 * ukoliko je employee.company_id prazan, znaci da taj employee ne radi nigde
	 */
	@Modifying
	@Query("update Employee e set e.company.id = ?2 where e.employeeId = ?1")
	void updateEmployeeCompany (Integer employeeId, Integer companyId);
	
}
