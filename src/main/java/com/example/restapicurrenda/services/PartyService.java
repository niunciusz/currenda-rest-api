package com.example.restapicurrenda.services;

import com.example.restapicurrenda.data.PartyRepository;
import com.example.restapicurrenda.data.activePages;
import com.example.restapicurrenda.models.PartyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {
    private final PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository){
        this.partyRepository = partyRepository;
    }

    public Iterable<activePages> findAllActiveForCaseState(String caseState){
        return partyRepository.findAllActiveForCaseState(caseState);
    }
    public Iterable<PartyEntity> list(){
        return partyRepository.findAll();
    }

    public PartyEntity load(PartyEntity entity){
        return partyRepository.save(entity);
    }

    public void load(List<PartyEntity> parties){
        partyRepository.saveAll(parties);
    }
}
