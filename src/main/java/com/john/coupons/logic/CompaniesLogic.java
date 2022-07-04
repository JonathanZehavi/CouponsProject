package com.john.coupons.logic;

import com.john.coupons.dto.Company;
import com.john.coupons.entities.CompanyEntity;
import com.john.coupons.repositories.ICompaniesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CompaniesLogic {

	private final ICompaniesRepository companiesRepository;

	@Autowired
	public CompaniesLogic(ICompaniesRepository companiesRepository) {
		this.companiesRepository = companiesRepository;
	}


	public Company createCompany(Company company) {
		CompanyEntity companyEntity = new CompanyEntity(company);
		companyEntity = companiesRepository.save(companyEntity);
		return new Company(companyEntity);
	}

	public Company updateCompany(Company company){
		CompanyEntity companyEntity = new CompanyEntity(company);
		companyEntity = companiesRepository.save(companyEntity);
		return new Company(companyEntity);
	}

	public CompanyEntity getCompany(int id) {
		CompanyEntity companyEntity = companiesRepository.findById(id);
		return companyEntity;
	}


	public void deleteCompany(int id) {
		companiesRepository.deleteById(id);
	}

	public List<Company> getAllCompanies(){
		List<Company> companyList = companiesRepository.getAllCompanies();
		return companyList;
	}

}
