package naprimer.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naprimer.demo.entity.Facility;
import naprimer.demo.exception.ResourceNotFoundException;
import naprimer.demo.model.FacilityModel;
import naprimer.demo.repository.FacilityRepository;

@Service
public class FacilityServiceImplementation implements FacilityService{
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Override
	public FacilityModel saveFacility(FacilityModel facility) {
		Facility facilityEntity = new Facility();
		facilityEntity.setFacilityId(facility.getId());
		facilityEntity.setName(facility.getName());
		facilityRepository.save(facilityEntity);
		return facilityToEntity(facilityEntity);
	}

	@Override
	public FacilityModel updateFacility(Integer facilityId, FacilityModel facility) {
		Optional<Facility> theFacility = facilityRepository.findById(facilityId);
		if(theFacility.isEmpty()) {
			throw new ResourceNotFoundException("Facility does not exist");
		}
		Facility facilityEntity = theFacility.get();
		facilityEntity.setName(facility.getName());
		facilityRepository.save(facilityEntity);
		return facilityToEntity(facilityEntity);
	}

	@Override
	public FacilityModel findById(Integer facilityId) {
		Optional<Facility> facility = facilityRepository.findById(facilityId);
		if(facility.isEmpty()) {
			throw new ResourceNotFoundException("Facility does not exist");
		}
		return facilityToEntity(facility.get());
	}

	@Override
	public void deleteFacility(Integer facilityId) {
		facilityRepository.deleteById(facilityId);
	}

	@Override
	public List<FacilityModel> getAllFacilities() {
		List<Facility> facilities = facilityRepository.findAll();
		List<FacilityModel> models = new ArrayList<>();
		for(Facility facility : facilities) {
			models.add(facilityToEntity(facility));
		}
		return models;
	}

	@Override
	public List<FacilityModel> getCompanyFacility(Integer companyId) {
		List<Facility> facilities = facilityRepository.getCompanyFacilities(companyId);
		List<FacilityModel> models = new ArrayList<>();
		for(Facility facility : facilities) {
			models.add(facilityToEntity(facility));
		}
		return models;
	}
	
	private FacilityModel facilityToEntity(Facility facility) {
		FacilityModel model = new FacilityModel();
		model.setId(facility.getFacilityId());
		model.setName(facility.getName());
		return model;
	}

}
