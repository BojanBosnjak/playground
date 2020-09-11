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

import naprimer.demo.model.FacilityModel;
import naprimer.demo.service.FacilityService;

@RestController
public class FacilityRestController {
	@Autowired
	private FacilityService facilityService;
	
	@GetMapping("/facilities")
	public List<FacilityModel> getAllFacilities(){
		return facilityService.getAllFacilities();
	}
	
	@GetMapping("/facilities/{facilityId}")
	public FacilityModel findById(@PathVariable ("facilityId")Integer facilityId) {
		return facilityService.findById(facilityId);
	}
	
	/*Find facility by name
	 */
	
	@GetMapping("/facilities/company/{companyId}")
	public List<FacilityModel> getCompanyFacility(@PathVariable ("companyId") Integer companyId){
		return facilityService.getCompanyFacility(companyId);
	}
	
	@PostMapping("/facilities/create")
	public FacilityModel saveFacility(@Valid @RequestBody FacilityModel model) {
		return facilityService.saveFacility(model);
	}
	
	@PutMapping("/facilities/{facilityId}")
	public FacilityModel updateFacility(@PathVariable ("facilityId") Integer facilityId, @Valid @RequestBody FacilityModel model) {
		return facilityService.updateFacility(facilityId, model);
	}
	
	@DeleteMapping("/facilities/{facilityId}")
	public void deleteFacility(@PathVariable ("facilityId") Integer facilityId) {
		facilityService.deleteFacility(facilityId);
	}
}
