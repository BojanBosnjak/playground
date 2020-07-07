package naprimer.demo.service;

import java.util.List;

import naprimer.demo.model.FacilityModel;

public interface FacilityService {
	FacilityModel saveFacility(FacilityModel facility);

	FacilityModel updateFacility(Integer facilityId, FacilityModel facility);

	FacilityModel findById(Integer facilityId);

	void deleteFacility(Integer facilityId);

	List<FacilityModel> getAllFacilities();

	//vraca listu facility koje pripadaju kompaniji sa zadatim id-em
	List<FacilityModel> getCompanyFacility(Integer companyId);

}
