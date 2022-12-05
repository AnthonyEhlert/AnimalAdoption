/*
 * @author Noah Clark - npclark
 * CIS 175 Fall 2022
 * Dec 1, 2022
 */

package adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import adoption.beans.VetRecord;
import adoption.repository.AnimalRepository;
import adoption.repository.VetRecordRepository;


@Controller
public class VetRecordController {
	@Autowired
	VetRecordRepository vetRecordRepo;
	
	@Autowired
	AnimalRepository animalRepo;
	
	@GetMapping("/viewAllVetRecords")
	public String viewAllVetRecords(Model model) {
		model.addAttribute("vetRecords", vetRecordRepo.findAll());
		return "vetRecordResults";
	}
	
	@GetMapping("inputVetRecord")
	public String addNewVetRecord(Model model) {
		VetRecord vr = new VetRecord();
		model.addAttribute("animals", animalRepo.findAll());
		model.addAttribute("newVetRecord", vr);
		return "inputVetRecord";
	}
	
	@PostMapping("/inputVetRecord")
	public String addNewVetRecord(@ModelAttribute VetRecord vr, Model model) {
		vetRecordRepo.save(vr);
		return viewAllVetRecords(model);
	}
	
	@GetMapping("editVetRecord/{id}")
	public String showUpdateVetRecord(@PathVariable("id") long id, Model model) {
		VetRecord vr = vetRecordRepo.findById(id).orElse(null);
		model.addAttribute("animals", animalRepo.findAll());
		model.addAttribute("newVetRecord", vr);
		return "inputVetRecord";
	}
	
	@PostMapping("/updateVetRecord/{id}")
	public String reviseVetRecord(VetRecord vr, Model model) {
		vetRecordRepo.save(vr);
		return viewAllVetRecords(model);
	}
	
	@GetMapping("/deleteVetRecord/{id}")
	public String deleteVetRecord(@PathVariable("id") long id, Model model) {
		VetRecord vr = vetRecordRepo.findById(id).orElse(null);
		vetRecordRepo.delete(vr);
		return viewAllVetRecords(model);
	}
}
