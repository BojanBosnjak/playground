package naprimer.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentModel {
	private Integer id;
	private LocalDate termin;
	private LocalTime pocetak;
	private LocalTime kraj;
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
	public LocalTime getPocetak() {
		return pocetak;
	}
	public void setPocetak(LocalTime pocetak) {
		this.pocetak = pocetak;
	}
	public LocalTime getKraj() {
		return kraj;
	}
	public void setKraj(LocalTime kraj) {
		this.kraj = kraj;
	}

}
