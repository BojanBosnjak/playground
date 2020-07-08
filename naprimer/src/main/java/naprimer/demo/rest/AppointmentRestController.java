package naprimer.demo.rest;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import naprimer.demo.model.AppointmentModel;
import naprimer.demo.service.AppointmentService;

@RestController
public class AppointmentRestController {
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/appointment/facility/{facilityId}")
	public List<AppointmentModel> getFacilityAppointment(@PathVariable("facilityId") Integer facilityId) {
		return appointmentService.getFacilityAppointments(facilityId);
	}

	@GetMapping("/appointment/employee/{employeeId}")
	public List<AppointmentModel> getEmployeeAppointment(@PathVariable("employeeId") Integer employeeId) {
		return appointmentService.getEmployeeAppointments(employeeId);
	}

	/*
	 * Ispada da i ova metoda radi isto sto i metoda iznad... kada napisem
	 * List<AppointmentModel
	 */
	@GetMapping("/appointment/total/employee/{employeeId}")
	public Integer getTotalEmployeeAppointments(@PathVariable("employeeId") Integer employeeId) {
		return appointmentService.getTotalEmployeeAppointments(employeeId);
	}

	/**/
	@GetMapping("/company/{companyId}/apointments")
	public Integer getTotalCompanyAppointments(
			@RequestParam("termin1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin1,
			@RequestParam("termin2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate termin2,
			@PathVariable("companyId") Integer companyId) {
		return appointmentService.getTotalCompanyAppointments(termin1, termin2, companyId);

	}
/*Princip metode iznad promeniti na metodu ispod i pronaci kako da ubacim i id-eve gde i sta radi, ko...*/
	/**/
	@GetMapping("/appointment/totalAppointments/{companyId}")
	public List<AppointmentModel> listTotalCompanyAppointments(
			@RequestParam("termin1") LocalDate termin1,
			@RequestParam("termin2") LocalDate termin2, 
			@PathVariable("companyId") Integer companyId) {
		return appointmentService.listTotalCompanyAppointments(termin1, termin2, companyId);

	}

	/**/
	@PostMapping("/appointment/create")
	public AppointmentModel createAppointment(@Valid @RequestBody AppointmentModel model) {
		return appointmentService.createAppointment(model);
	}

}
