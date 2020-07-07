package naprimer.demo.service;

import java.util.List;

import naprimer.demo.model.EmployeeModel;

public interface EmployeeService {
	EmployeeModel saveEmployee(EmployeeModel employee);

	EmployeeModel updateEmployee(Integer employeeId, EmployeeModel employee);

	EmployeeModel getEmployeeById(Integer employeeId);

	List<EmployeeModel> getAllEmployees();

	void deleteEmployee(Integer employeeId);
	
	//Daje listu zaposlenih u kompaniji sa zadatim id-em
	List<EmployeeModel> getCompanyEmployees(Integer companyId);
	
	void updateEmployeeAuthority(Integer employeeId, EmployeeModel model);
	
	void updateEmployeeCompany(Integer employeeId, EmployeeModel employeeModel);
	
}
