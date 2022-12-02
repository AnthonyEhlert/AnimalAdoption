package adoption.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import adoption.beans.Animal;
import adoption.beans.AnimalOfDay;
import adoption.repository.AnimalOfDayRepository;
import adoption.repository.AnimalRepository;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Dec 2, 2022
 */

@Controller
public class AnimalOfDayWebController {
	
	@Autowired
	AnimalRepository animalRepo;
	
	@Autowired
	AnimalOfDayRepository animalOfDayRepo;
	
	//test method
//	@GetMapping("/viewAnimalOfDay")
//	public String viewAnimalOfDay(Model model) {
//		Animal animalTest = animalRepo.findById(animalRepo.findAvailableMaxId()).orElse(null);
//		AnimalOfDay animalOfDayTest = new AnimalOfDay(animalTest);
//		animalOfDayRepo.save(animalOfDayTest);
//		model.addAttribute("animalOfDay", animalOfDayTest);
//		return "viewAnimalOfDay";
//	}
	
	@GetMapping("/viewAnimalOfDay")
	public String viewAnimalOfDay(Model model) {
//		LocalDate animalOfDayDate = LocalDate.now();
		if(animalOfDayRepo.findByDate() == null) {
			LocalDate animalOfDayDate = LocalDate.now();
			Animal animalTest = animalRepo.findById(animalRepo.findRandomId()).orElse(null);
			AnimalOfDay animalOfDay = new AnimalOfDay(animalTest, animalOfDayDate);
			animalOfDayRepo.save(animalOfDay);
			model.addAttribute("animalOfDay", animalOfDay);
		} else {
			AnimalOfDay animalOfDay = animalOfDayRepo.findById(animalOfDayRepo.findIdByDate()).orElse(null);
			model.addAttribute("animalOfDay", animalOfDay);
		}
		return "viewAnimalOfDay";
	}
	
}
