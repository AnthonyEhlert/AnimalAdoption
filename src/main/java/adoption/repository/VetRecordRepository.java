/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Dec 1, 2022
 */

package adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adoption.beans.VetRecord;

public interface VetRecordRepository extends JpaRepository<VetRecord, Long>{

}
