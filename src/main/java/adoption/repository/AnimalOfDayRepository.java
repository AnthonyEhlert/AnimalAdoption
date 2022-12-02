package adoption.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import adoption.beans.Animal;
import adoption.beans.AnimalOfDay;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Dec 2, 2022
 */
public interface AnimalOfDayRepository extends JpaRepository<AnimalOfDay, Long>{

	LocalDate today = LocalDate.now();
	
	@Query(value = "SELECT date FROM animal_of_day WHERE date = DATE(NOW())", nativeQuery = true)
	LocalDate findByDate();
	
	@Query(value = "SELECT id FROM animal_of_day WHERE date = DATE(NOW())", nativeQuery = true)
	long findIdByDate();
	
	@Query(value = "SELECT id FROM animal_of_day ORDER BY RAND() LIMIT 1", nativeQuery = true)
	long findRandomId();
}
