package adoption.beans;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import adoption.repository.AnimalRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Dec 2, 2022
 */

@Data
@NoArgsConstructor
@Entity
public class AnimalOfDay {
	
//	@Autowired
//	AnimalRepository animalRepo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
//	@NonNull
	@Column(unique=true)
	private LocalDate date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Animal animalOfDay;
	
	//Helper constructor to assign maxId animal
	public AnimalOfDay(Animal animal, LocalDate date) {
		super();
		this.animalOfDay = animal;
		this.date = date;
	}
	
	//function to select random available animal
	
	
}
