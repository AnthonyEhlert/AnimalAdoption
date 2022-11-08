package adoption.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private LocalDateTime lastFed;
	
	private boolean available;
}
