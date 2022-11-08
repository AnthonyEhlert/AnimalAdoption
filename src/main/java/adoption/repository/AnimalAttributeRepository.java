package adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adoption.beans.AnimalAttribute;

/**
 * @author Tony Ehlert - aehlert
 * CIS175 - Fall 2022
 * Nov 8, 2022
 */
public interface AnimalAttributeRepository extends JpaRepository<AnimalAttribute, Long>{

}
