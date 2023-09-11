package com.example.restapicurrenda.services;

import com.example.restapicurrenda.data.CaseRepository;
import com.example.restapicurrenda.data.caseCount;
import com.example.restapicurrenda.models.CaseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CaseService {
    private final CaseRepository caseRepository;

    public CaseService(CaseRepository caseRepository){
        this.caseRepository = caseRepository;
    }

    public Iterable<CaseEntity> list(){
        return caseRepository.findAll();
    }

    public Iterable<caseCount> findAllBetweenAndType(Date start, Date end, String type){
        return caseRepository.findAllTimeWindowAndCaseType(start, end, type);
    }
    public Iterable<CaseEntity> findAllX(){
        return caseRepository.findAllX();
    }

    public CaseEntity load(CaseEntity entity){
        return caseRepository.save(entity);
    }

    public void load(List<CaseEntity> cases){
        caseRepository.saveAll(cases);
    }
}
