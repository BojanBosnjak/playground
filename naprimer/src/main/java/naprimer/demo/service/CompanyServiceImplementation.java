package naprimer.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naprimer.demo.entity.Company;
import naprimer.demo.exception.ResourceNotFoundException;
import naprimer.demo.model.CompanyModel;
import naprimer.demo.repository.CompanyRepository;
import naprimer.demo.repository.EmployeeRepository;

@Service
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
//	@Autowired EmployeeRepository employeeRepository;

//	@Autowired
//	private PasswordEncoder PasswordEncoder;

	@Override
	public CompanyModel saveCompany(CompanyModel company) {
		Company companyEntity = new Company();
		companyEntity.setCompanyId(company.getId());
		/*
		 * Password encoder String password =
		 * passwordEncoder.encode(company.getPassword());
		 * companyEntity.setPAssword(password);
		 */
		companyEntity.setName(company.getName());
		/*
		 * Posle dodati ostale metode koje se budu ticale company
		 */
		companyRepository.save(companyEntity);
		return companyToModel(companyEntity);
	}

	@Override
	public CompanyModel updateCompany(Integer companyId, CompanyModel company) {
		Optional<Company> theCompany = companyRepository.findById(companyId);
		if (theCompany.isEmpty()) {
			throw new ResourceNotFoundException("Company not found");
		}
		Company companyEntity = theCompany.get();
		companyEntity.setName(company.getName());
		// isto dodati za ostale stvari koje planiramo da azuriramo u buducnosti
		companyRepository.save(companyEntity);
		return companyToModel(companyEntity);
	}

	@Override
	public CompanyModel getCompanyById(Integer companyId) {
		Optional<Company> theCompany = companyRepository.findById(companyId);
		if (theCompany.isEmpty()) {
			throw new ResourceNotFoundException("Company not found");
		}
		return companyToModel(theCompany.get());
	}
	
	@Override
	public CompanyModel findByName(String name) {
		Optional <Company> theCompany = companyRepository.findByName(name);
		if(theCompany.isEmpty()) {
			throw new ResourceNotFoundException("Company not found");
		}
		return companyToModel(theCompany.get());
	}

	@Override
	public List<CompanyModel> getAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		List<CompanyModel> models = new ArrayList<>();
		for (Company company : companies) {
			models.add(companyToModel(company));
		}
		return models;
	}

	@Override
	public void deleteCompany(Integer companyId) {
		companyRepository.deleteById(companyId);

	}
	
	//metoda kojom company radi update na employee authority
//	public void setEmployeeAuthority(Integer employeeId, int authority) {
//		employeeRepository.updateEmployeeAuthority(employeeId, authority);
//	}

	// Metoda koja sluzi da nesto pretvorimo entitet u model
	private CompanyModel companyToModel(Company company) {
		CompanyModel companyModel = new CompanyModel();
		companyModel.setId(company.getCompanyId());
		companyModel.setName(company.getName());
		return companyModel;
	}


}
