package adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import adoption.beans.Animal;
import adoption.beans.AnimalAttribute;
import adoption.beans.Adopter;
import adoption.repository.AnimalAttributeRepository;
import adoption.repository.AnimalRepository;
import adoption.repository.AdopterRepository;

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
		return "availableAnimalResults";
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
	
	@RequestMapping ("/searchAnimalType")
	public String searchAnimalType(@RequestParam("animalType") String animalType, Model model) {
	    model.addAttribute("animals", animalRepo.findByAnimalType(animalType));
	    return "animalResults";
	    }
	
	//AnimalAttribute methods
	@GetMapping("/viewAllAnimalAttributes")
	public String viewAllAnimalAttributes(Model model) {
		model.addAttribute("animalAttributes", attributeRepo.findAll());
		return "animalAttributeResults";
	}
	
	@GetMapping("inputAnimalAttribute")
	public String addNewAnimalAttribute(Model model) {
		AnimalAttribute aa = new AnimalAttribute();
		model.addAttribute("newAnimalAttribute", aa);
		return "inputAnimalAttribute";
	}
	
	@PostMapping("/inputAnimalAttribute")
	public String addNewAnimalAttribute(@ModelAttribute AnimalAttribute aa, Model model) {
		attributeRepo.save(aa);
		return viewAllAnimalAttributes(model);
	}
	
	@GetMapping("/editAnimalAttribute/{id}")
	public String showUpdateAnimalAttribute(@PathVariable("id") long id, Model model) {
		AnimalAttribute aa = attributeRepo.findById(id).orElse(null);
		model.addAttribute("newAnimalAttribute", aa);
		return "inputAnimalAttribute";
	}
	
	@PostMapping("/updateAnimalAttribute/{id}")
	public String reviseAnimalAttribute(AnimalAttribute aa, Model model) {
		attributeRepo.save(aa);
		return viewAllAnimalAttributes(model);
	}
	
	@GetMapping("/deleteAnimalAttribute/{id}")
	public String deleteAnimalAttribute(@PathVariable("id") long id, Model model) {
		AnimalAttribute aa = attributeRepo.findById(id).orElse(null);
		attributeRepo.delete(aa);
		return viewAllAnimalAttributes(model);
	}
}
