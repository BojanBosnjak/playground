package naprimer.demo.rest;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import naprimer.demo.model.AppointmentModel;
import naprimer.demo.service.AppointmentService;

@RestController
public class AppointmentRestController {
	@Autowired
	private AppointmentService appointmentService;
	
/*Create, Update, Delete actions over Appointment*/	
	@PostMapping("/appointment/create")
	public AppointmentModel createAppointment(@Valid @RequestBody AppointmentModel model) {
		return appointmentService.createAppointment(model);
	}
		/*Za sad nemam nacin da odmah ubacim id kompanije za koju zaposleni radi, ali to mogu da uradim zahvaljujuci update metodi
		 */

	@PutMapping("/appointment/{appointmentId}")
	public AppointmentModel updateAppointment(@PathVariable("appointmentId") Integer appointmentId, @Valid @RequestBody AppointmentModel model) {
		return appointmentService.updateAppointment(appointmentId, model);
	}
	@DeleteMapping("/appointment/{appointmentId}")
	public void deleteAppointment(@PathVariable("appointmentId") Integer appointmentId) {
		appointmentService.deleteAppointment(appointmentId);
	}
	
/*Facility*/
	@GetMapping("/appointment/facility/{facilityId}")
	public List<AppointmentModel> getFacilityAppointment(@PathVariable("facilityId") Integer facilityId) {
		return appointmentService.getFacilityAppointments(facilityId);
	}

	/*Get methods*/
/*Employee*/	
	@GetMapping("/appointment/employee/{employeeId}")
	public List<AppointmentModel> getEmployeeAppointment(@PathVariable("employeeId") Integer employeeId) {
		return appointmentService.getEmployeeAppointments(employeeId);
	}
	/* Metode getEmployeeAppointment i getTotalEmployeeAppointments vracaju listu, odnosno broj sastanaka koji je zadati zaposleni imao generalno
	 * Mislim da postoji potreba da imam metode koje ce uzimati kao @PathVariable i companyId, na taj nacin cu moci sa sigurnoscu da kazem da
	 * je zaposleni bas te firme imao bas taj broj, ili listu sastanaka.
	 * EmployeeId je svakako jedinstven i na osnovu njega znam da je to bas taj zaposleni, ali nigde nemam informaciju o kompaniji za koju radi
	 * tako da ne bi bilo lose da kompaniji dam mogucnost da to izlista.
	 */
	@GetMapping("/appointment/total/employee/{employeeId}")
	public Integer getTotalEmployeeAppointments(@PathVariable("employeeId") Integer employeeId) {
		return appointmentService.getTotalEmployeeAppointments(employeeId);
	}

/*Company*/
	@GetMapping("/company/{companyId}/apointments")
	public Integer getTotalCompanyAppointments(
			@RequestParam("termin1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin1,
			@RequestParam("termin2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin2,
			@PathVariable("companyId") Integer companyId) {
		return appointmentService.getTotalCompanyAppointments(termin1, termin2, companyId);

	}

	@GetMapping("/appointment/totalAppointments/{companyId}")
	public List<AppointmentModel> listTotalCompanyAppointments(
			@RequestParam("termin1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin1,
			@RequestParam("termin2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin2, 
			@PathVariable("companyId") Integer companyId) {
		return appointmentService.listTotalCompanyAppointments(termin1, termin2, companyId);

	}
	
/*User*/
	@GetMapping("/appointment/user/{userId}")
	public List<AppointmentModel> getUsersAppointments (@PathVariable ("userId") Integer userId){
		return appointmentService.getUsersAppointments(userId);
	}
	
/********** End of get methods related to appointment************/
	


}
