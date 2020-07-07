package naprimer.demo.service;

import java.time.LocalDate;
import java.util.List;
import naprimer.demo.model.AppointmentModel;

public interface AppointmentService {
	AppointmentModel createAppointment(AppointmentModel model);

	AppointmentModel updateAppointment(Integer appointmentId, AppointmentModel model);

	void deleteAppointment(Integer appointmentId);

	List<AppointmentModel> getFacilityAppointments(Integer facilityId);

	/*
	 * Kada saljem upit neke stvari ne prikazuje kako pise u bazi. Brka vreme, negde
	 * stavi sat vise negde sat manje
	 */
	List<AppointmentModel> getEmployeeAppointments(Integer employeeId);

	/*
	 * Ovde mi treba upit koji ce da mi posalje broj koliko je taj zaposleni imao
	 * sastanaka. Posle toga cu trebati da napravim koliko je on dugo radio te
	 * sastanke
	 */

	public Integer getTotalEmployeeAppointments(Integer employeeId);

	public Integer getTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);

	List<AppointmentModel> listTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId);
}
