package com.example.restapicurrenda.data;

import com.example.restapicurrenda.models.AddressEmbedded;
import com.example.restapicurrenda.models.CaseEntity;
import com.example.restapicurrenda.models.PartyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PartyRepository extends CrudRepository<PartyEntity, Long> {

    //Dla zadanego caseState zwraca adresy aktywnych stron
     @Query(value= "select city, postal_code as postalCode, street from PARTY_ADDRESSES where PARTY_ID IN ( SELECT b.ID FROM CASE_ENTITY  as a left join  PARTY_ENTITY as b on a.case_id=b.case_id where  " + "(?1 is null or a.case_state = ?1) " + " and b.active=true)", nativeQuery = true)
    //@Query(value= "select p from AddressEmbedded p where p.id IN ( SELECT b.ID FROM CaseEntity a left join  PartyEntity b on a.caseId=b.caseId where  " + "(?1 is null or a.caseState = ?1) " + " and b.active=true)", nativeQuery = false)
    List<activePages> findAllActiveForCaseState(
            String caseState
    );
}
