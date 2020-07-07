package naprimer.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import naprimer.demo.model.EmployeeModel;
import naprimer.demo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<EmployeeModel> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{employeeId}")
	public EmployeeModel getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@GetMapping("/employees/company/{companyId}")
	public List<EmployeeModel> getCompanyEmployees(@PathVariable("companyId") Integer companyId) {
		return employeeService.getCompanyEmployees(companyId);
	}

	@PostMapping("/employees/create")
	public EmployeeModel saveEmployee(@Valid @RequestBody EmployeeModel model) {
		return employeeService.saveEmployee(model);
	}

	@PutMapping("/employees/{employeeId}")
	public EmployeeModel updateEmployee(@PathVariable("employeeId") Integer employeeId,
			@Valid @RequestBody EmployeeModel model) {
		return employeeService.updateEmployee(employeeId, model);
	}

	@PutMapping("/employees/authority/{employeeId}")
	public void updateEmployeeAuthority(@PathVariable("employeeId") Integer employeeId,
			@Valid @RequestBody EmployeeModel model) {
		employeeService.updateEmployeeAuthority(employeeId, model);
	}
	
	@PutMapping("/employees/company/{employeeId}")
	public void updateEmployeeCompany (@PathVariable("employeeId") Integer employeeId, @Valid @RequestBody EmployeeModel model) {
		employeeService.updateEmployeeCompany(employeeId, model);
	}

}
