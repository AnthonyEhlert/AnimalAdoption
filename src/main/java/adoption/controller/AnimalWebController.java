package adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import adoption.beans.Animal;
import adoption.repository.AnimalAttributeRepository;
import adoption.repository.AnimalRepository;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Nov 8, 2022
 */

@Controller
public class AnimalWebController {

	@Autowired
	AnimalRepository animalRepo;
	
	@Autowired
	AnimalAttributeRepository attributeRepo;
	
	@GetMapping("/viewAllAnimals")
	public String viewAllAnimals(Model model) {
		model.addAttribute("animals", animalRepo.findAll());
		return "animalResults";
	}
	
	@GetMapping("/viewAvailableAnimals")
	public String viewAvailableAnimals(Model model) {
		model.addAttribute("animals", animalRepo.findByAvailable(true));
		return "avilableAnimalResults";
	}
	
	@GetMapping("inputAnimal")
	public String addNewAnimal(Model model) {
		Animal a = new Animal();
		model.addAttribute("animalAttributes", attributeRepo.findAll());
		model.addAttribute("newAnimal", a);
		return "inputAnimal";
	}
	
	@PostMapping("/inputAnimal")
	public String addNewAnimal(@ModelAttribute Animal a, Model model) {
		animalRepo.save(a);
		return viewAllAnimals(model);
	}
	
	@GetMapping("/editAnimal/{id}")
	public String showUpdateAnimal(@PathVariable("id") long id, Model model) {
		Animal a = animalRepo.findById(id).orElse(null);
		model.addAttribute("newAnimal", a);
		return "inputAnimal";
	}
	
	@PostMapping("/updateAnimal/{id}")
	public String reviseAnimal(Animal a, Model model) {
		animalRepo.save(a);
		return viewAllAnimals(model);
	}
	
	@GetMapping("/deleteAnimal/{id}")
	public String deleteAnimal(@PathVariable("id") long id, Model model) {
		Animal a = animalRepo.findById(id).orElse(null);
		animalRepo.delete(a);
		return viewAllAnimals(model);
	}
}
