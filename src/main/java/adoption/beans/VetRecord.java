/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Dec 1, 2022
 */

package adoption.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class VetRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Animal animal;
	
	private String vetName;
	private String diagnosis;
}
