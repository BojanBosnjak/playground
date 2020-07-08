package naprimer.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate termin;// pocetak termina - "termin":"2020-04-04T16:00:00",
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime pocetak;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime kraj;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
