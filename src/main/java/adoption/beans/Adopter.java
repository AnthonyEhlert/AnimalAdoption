/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 14, 2022
 */

package adoption.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Adopter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email;
	private String phone;
	
//	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
//	private List<AnimalAttribute> listOfAttributes;
}
