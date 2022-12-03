/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 14, 2022
 */

package adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import adoption.beans.Adopter;
import adoption.repository.AdopterRepository;

@Controller
public class AdopterWebController {
	@Autowired
	AdopterRepository adopterRepo;
	
	@GetMapping("/viewAllAdopters")
	public String viewAllAdopters(Model model) {
		model.addAttribute("adopters", adopterRepo.findAll());
		return "adopterResults";
	}
	
	@GetMapping("inputAdopter")
	public String addNewAdopter(Model model) {
		Adopter ad = new Adopter();
		model.addAttribute("newAdopter", ad);
		return "inputAdopter";
	}
	
	@PostMapping("/inputAdopter")
	public String addNewAdopter(@ModelAttribute Adopter ad, Model model) {
		adopterRepo.save(ad);
		return viewAllAdopters(model);
	}
	
	@GetMapping("editAdopter/{id}")
	public String showUpdateAdopter(@PathVariable("id") long id, Model model) {
		Adopter ad = adopterRepo.findById(id).orElse(null);
		model.addAttribute("newAdopter", ad);
		return "inputAdopter";
	}
	
	@PostMapping("/updateAdopter/{id}")
	public String reviseAdopter(Adopter ad, Model model) {
		adopterRepo.save(ad);
		return viewAllAdopters(model);
	}
	
	@GetMapping("/deleteAdopter/{id}")
	public String deleteAdopter(@PathVariable("id") long id, Model model) {
		Adopter ad = adopterRepo.findById(id).orElse(null);
		adopterRepo.delete(ad);
		return viewAllAdopters(model);
	}
}
