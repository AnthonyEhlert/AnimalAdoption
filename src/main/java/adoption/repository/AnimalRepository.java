package adoption.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import adoption.beans.Animal;


/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Nov 8, 2022
 */
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	List<Animal> findByAvailable(boolean available);
	
	List<Animal> findByAnimalType(String animalType);
}
