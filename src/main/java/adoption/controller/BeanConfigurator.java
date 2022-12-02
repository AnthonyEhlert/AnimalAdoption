package adoption.controller;

import org.springframework.context.annotation.Bean;

import adoption.beans.Animal;
import adoption.beans.AnimalAttribute;
import adoption.beans.AnimalOfDay;
import adoption.beans.Adopter;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Nov 8, 2022
 */
public class BeanConfigurator {

	@Bean
	public Animal animal() {
		Animal bean = new Animal();
		return bean;
	}
	
	@Bean
	public AnimalAttribute animalAttribute() {
		AnimalAttribute bean = new AnimalAttribute();
		return bean;
	}
	
	@Bean
	public Adopter adopter() {
		Adopter bean = new Adopter();
		return bean;
	}
	
	@Bean
	public AnimalOfDay animalOfDay() {
		AnimalOfDay bean = new AnimalOfDay();
		return bean;
	}
}
