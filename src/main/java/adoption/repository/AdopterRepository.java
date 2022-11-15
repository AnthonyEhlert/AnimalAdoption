/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Nov 14, 2022
 */

package adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adoption.beans.Adopter;

public interface AdopterRepository extends JpaRepository<Adopter, Long>{

}
