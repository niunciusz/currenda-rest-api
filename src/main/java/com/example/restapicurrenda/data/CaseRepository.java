package com.example.restapicurrenda.data;

import com.example.restapicurrenda.models.CaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CaseRepository extends CrudRepository<CaseEntity, Long> {

    //Dla zadnego zakresu dat (według dateOfEntry) i caseType zwraca liczbę spraw pogrupowaną według caseState
    @Query(value="SELECT count(c) as count, c.caseState as caseState FROM CaseEntity c WHERE " + "(?3 is null or c.caseType = ?3) " + "and c.dateOfEntry between ?1 and ?2 group by c.caseState", nativeQuery = false)
    Collection<caseCount> findAllTimeWindowAndCaseType(
            Date timeStart,
            Date timeEnd,
            String caseType);
    @Query(
            value = "SELECT c FROM CaseEntity c",
            nativeQuery = false)
    List<CaseEntity> findAllX();

}


