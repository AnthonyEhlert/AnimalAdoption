package adoption.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class AnimalAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String attributeName;
	
	//@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@ManyToMany(mappedBy= "listOfAttributes", cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<Animal> listOfAnimals;
}
