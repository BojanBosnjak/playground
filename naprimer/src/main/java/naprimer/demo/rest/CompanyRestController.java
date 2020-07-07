package naprimer.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import naprimer.demo.model.CompanyModel;
import naprimer.demo.service.CompanyService;

@RestController
public class CompanyRestController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/companies")
	public List<CompanyModel> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/companies/{companyId}")
	public CompanyModel getCompanyById(@PathVariable ("companyId") Integer companyId) {
		return companyService.getCompanyById(companyId);
	}
	
	@PostMapping("/create")
	public CompanyModel saveCompany (@Valid @RequestBody CompanyModel comapny) {
		return companyService.saveCompany(comapny);
	}
	
	@PutMapping("/companies/{companyId}")
	public CompanyModel updateCompany (@PathVariable ("companyId") Integer companyId, @Valid @RequestBody CompanyModel comapny) {
		return companyService.updateCompany(companyId, comapny);
	}
	
	@DeleteMapping("companies/{companyId}")
	public void deleteCompany (@PathVariable ("companyId") Integer companyId) {
		companyService.deleteCompany(companyId);
	}
}
