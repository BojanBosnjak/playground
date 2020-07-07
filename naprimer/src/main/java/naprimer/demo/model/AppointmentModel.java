package naprimer.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentModel {
	private Integer id;
	private LocalDate termin;
	private LocalDate trajanje;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getTermin() {
		return termin;
	}
	public void setTermin(LocalDate termin) {
		this.termin = termin;
	}
	public LocalDate getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(LocalDate trajanje) {
		this.trajanje = trajanje;
	}

	
	
}
