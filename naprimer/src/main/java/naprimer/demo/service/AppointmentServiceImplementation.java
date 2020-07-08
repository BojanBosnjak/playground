package naprimer.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naprimer.demo.entity.Appointment;
import naprimer.demo.exception.ResourceNotFoundException;
import naprimer.demo.model.AppointmentModel;
import naprimer.demo.repository.AppointmentRepository;

@Service
public class AppointmentServiceImplementation implements AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
/*Create, Update, Delete actions over Appointment*/
	@Override
	public AppointmentModel createAppointment(AppointmentModel model) {
		Appointment appointment = new Appointment();
		appointment.setId(model.getId());
		appointment.setTermin(model.getTermin());
		appointment.setPocetak(model.getPocetak());
		appointment.setKraj(model.getKraj());
		appointmentRepository.save(appointment);
		return appointmentToModel(appointment);
	}

	@Override
	public AppointmentModel updateAppointment(Integer appointmentId, AppointmentModel model) {
		Optional<Appointment> theAppointment = appointmentRepository.findById(appointmentId);
		if (theAppointment.isEmpty()) {
			throw new ResourceNotFoundException("Appointment not found");
		}
		Appointment appointmentEntity = theAppointment.get();
		appointmentEntity.setTermin(model.getTermin());
		appointmentEntity.setPocetak(model.getPocetak());
		appointmentEntity.setKraj(model.getKraj());
		appointmentRepository.save(appointmentEntity);
		return appointmentToModel(appointmentEntity);
	}

	@Override
	public void deleteAppointment(Integer appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}
	
	/*Get methods*/
/*Facility*/
	@Override
	public List<AppointmentModel> getFacilityAppointments(Integer facilityId) {
		List<Appointment> appointments = appointmentRepository.getFacilityAppointment(facilityId);
		List<AppointmentModel> models = new ArrayList<>();
		for (Appointment appointment : appointments) {
			models.add(appointmentToModel(appointment));
		}
		return models;
	}

/*Employee*/	
	@Override
	public List<AppointmentModel> getEmployeeAppointments(Integer employeeId) {
		List<Appointment> appointments = appointmentRepository.getEmployeeAppointment(employeeId);
		List<AppointmentModel> models = new ArrayList<>();
		for (Appointment appointment : appointments) {
			models.add(appointmentToModel(appointment));
		}
		return models;
	}

	@Override
	public Integer getTotalEmployeeAppointments(Integer employeeId) {
		int result = appointmentRepository.getTotalEmployeeAppointments(employeeId);
		return result;
	}

/*Company*/
	@Override
	public Integer getTotalCompanyAppointments(LocalDate termin1, LocalDate termin2, Integer companyId) {

		int result = appointmentRepository.getTotalCompanyAppointments(termin1, termin2, companyId);
		return result;
	}


	@Override
	public List<AppointmentModel> listTotalCompanyAppointments(LocalDate termin1, LocalDate termin2,
			Integer companyId) {
		List<Appointment> appointments = appointmentRepository.listTotalCompanyAppointments(termin1, termin2,
				companyId);
		List<AppointmentModel> models = new ArrayList<>();
		for (Appointment appointment : appointments) {
			models.add(appointmentToModel(appointment));
		}
		return models;
	}

/*User*/
	@Override
	public List<AppointmentModel> getUsersAppointments(Integer userId) {
		List<Appointment> theAppointments = appointmentRepository.getUsersAppointments(userId);
		List<AppointmentModel> models = new ArrayList<>();
		for (Appointment appointment : theAppointments) {
			models.add(appointmentToModel(appointment));
		}

		return models;
	}
	
	/*ToModel*/
	private AppointmentModel appointmentToModel(Appointment appointment) {
		AppointmentModel model = new AppointmentModel();
		model.setId(appointment.getId());
		model.setTermin(appointment.getTermin());
		model.setPocetak(appointment.getPocetak());
		model.setKraj(appointment.getKraj());
		return model;
	}

	

}
