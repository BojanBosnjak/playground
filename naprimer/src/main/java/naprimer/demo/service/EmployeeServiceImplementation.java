package naprimer.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import naprimer.demo.entity.Company;
import naprimer.demo.entity.Employee;
import naprimer.demo.exception.ResourceNotFoundException;
import naprimer.demo.model.EmployeeModel;
import naprimer.demo.repository.CompanyRepository;
import naprimer.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CompanyRepository companyRepository;
//	@Autowired
//	private PasswordEncoder PasswordEncoder;

	@Override
	public EmployeeModel saveEmployee(EmployeeModel employee) {
		Employee employeeEntity = new Employee();
		employeeEntity.setEmployeeId(employee.getId());
		employeeEntity.setName(employee.getName());
		/*
		 * Password encoder String password =
		 * passwordEncoder.encode(company.getPassword());
		 * companyEntity.setPassword(password);
		 * Posle dodati ostale metode koje se budu ticale company
		 */
		
		employeeRepository.save(employeeEntity);
		return employeeToModel(employeeEntity);
	}

	@Override
	public EmployeeModel updateEmployee(Integer employeeId, EmployeeModel employee) {
		Optional<Employee> theEmployee = employeeRepository.findById(employeeId);
		if(theEmployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee not found");
		}
		Employee employeeEntity = theEmployee.get();
		employeeEntity.setName(employee.getName());
		//isto uraditi i za ostale metode kada ih napravim
		employeeRepository.save(employeeEntity);
		return employeeToModel(employeeEntity);
	}

	@Override
	public EmployeeModel getEmployeeById(Integer employeeId) {
		Optional<Employee> theEmployee = employeeRepository.findById(employeeId);
		if(theEmployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee not found");
		}
		return employeeToModel(theEmployee.get());
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeModel> models = new ArrayList<>();
		for(Employee employee : employees) {
			models.add(employeeToModel(employee));
		}
		return models;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public List<EmployeeModel> getCompanyEmployees(Integer companyId) {
		List<Employee> theEmployees = employeeRepository.getCompanyEmployees(companyId);
		List<EmployeeModel> models = new ArrayList<>();
		for(Employee employee : theEmployees) {
			models.add(employeeToModel(employee));
		}
		return models;
	}

	@Transactional
	@Override
	public void updateEmployeeAuthority(Integer employeeId, EmployeeModel model) {
		
		employeeRepository.updateEmployeeAuthority(employeeId, model.getAuthority());
	}
//nisam siguran da li sam ovo dobro izveo
	@Transactional
	@Override
	public void updateEmployeeCompany(Integer employeeId, EmployeeModel model) {
		employeeRepository.updateEmployeeCompany(employeeId, model.getCompany());
	}
	
	private EmployeeModel employeeToModel(Employee employee) {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(employee.getEmployeeId());
		employeeModel.setName(employee.getName());
		//employeeModel.setAuthority(employee.getAuthority());
		return employeeModel;
	}

}
