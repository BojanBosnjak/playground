package naprimer.demo.service;

import java.util.List;

import naprimer.demo.model.CompanyModel;

public interface CompanyService {
	CompanyModel saveCompany(CompanyModel company);
	CompanyModel updateCompany(Integer companyId, CompanyModel company);
	CompanyModel getCompanyById(Integer companyId);
	List<CompanyModel> getAllCompanies();
	void deleteCompany(Integer companyId);
}
