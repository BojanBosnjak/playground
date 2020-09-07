package naprimer.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import naprimer.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
/*Appointment in facility*/
	@Query("select a from Appointment a where a.facility.facilityId=:facilityId")
	List<Appointment> getFacilityAppointment(Integer facilityId);

/*List of employee appointments*/
	@Query("select a from Appointment a where a.employee.employeeId=:employeeId")
	List<Appointment> getEmployeeAppointment(Integer employeeId);

/*Total number of employee appointments*/
	@Query(value = "select count(*) from appointment where employee_id=:employeeId", nativeQuery = true)
	public Integer getTotalEmployeeAppointments(Integer employeeId);

/*Total number of company appointments*/
	@Query(value = "select count(*) from appointment where termin between ?1 and ?2 and company_id=?3", nativeQuery = true)
	public Integer getTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);
	/*
	 * Ova metoda vraca broj sastanaka koji su odrzani na nivou cele kompanije
	 */
	
/*List of company appointments*/
	@Query(value = "select * from appointment where termin between ?1 and ?2 and company_id=?3", nativeQuery = true)
	List<Appointment> listTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);
	/*
	 * Ovo je metoda koja daje kompaniji informacije koji su sastanci bili u
	 * odredjenom vremenskom periodu Ko je vodio sastanak (izvrsavao uslugu) Kome je
	 * usluga bila izvrsena U kom objektu Koji zaposleni je izvrsio uslugu
	 */

/*List of user Appointments*/
	@Query("select a from Appointment a where a.user.userId=:userId")
	List<Appointment> getUsersAppointments (Integer userId);

	@Query("select a from Appointment a join a.company c where a.termin between (:termin1, :termin2) and c.id=:companyId")
	List<Appointment> listTotalCompanyAppointments234(LocalDate termin1, LocalDate termin2, Integer companyId);
	
	List<Appointment> findByTerminBetween(LocalDate termin1, LocalDate termin2);

	
}
