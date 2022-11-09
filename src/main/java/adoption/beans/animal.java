package adoption.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Nov 8, 2022
 */

@Data
@NoArgsConstructor
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Integer age;
	private String name;
	private String description;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate lastFedDate;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime lastFedTime;
	
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	//@ManyToMany(mappedBy= "listOfAnimals", cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER) 
	private List<AnimalAttribute> listOfAttributes;
	
	private boolean available;
}
