package naprimer.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import naprimer.demo.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	@Query("select a from Appointment a where a.facility.facilityId=:facilityId")
	List<Appointment> getFacilityAppointment(Integer facilityId);

	@Query("select a from Appointment a where a.employee.employeeId=:employeeId")
	List<Appointment> getEmployeeAppointment(Integer employeeId);

	@Query(value = "select count(*) from appointment where employee_id=:employeeId", nativeQuery = true)
	public Integer getTotalEmployeeAppointments(Integer employeeId);

	@Query(value = "select count(*) from appointment where termin between termin1=?1 and termin2=?2 and company_id=?3", nativeQuery = true)
	public Integer getTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);
	/*
	 * Ova metoda vraca broj sastanaka koji su odrzani na nivou cele kompanije
	 */

	@Query(value = "select * from appointment where termin between termin1=?1 and termin2=?2 and company_id=?3", nativeQuery = true)
	List<Appointment> listTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);
	/*
	 * Pitanje glasi, da li ja ova 3 parametra mogu ovako da saljem u query? Posto
	 * datume saljem u String formatu, napravio sam 3 stringa koji predstavljaju
	 * termin1="2020-03-03"; termin2="2020-04-04"
	 * 
	 * Ovo je metoda koja daje kompaniji informacije koji su sastanci bili u
	 * odredjenom vremenskom periodu Ko je vodio sastanak (izvrsavao uslugu) Kome je
	 * usluga bila izvrsena U kom objektu Koji zaposleni je izvrsio uslugu
	 */

}
