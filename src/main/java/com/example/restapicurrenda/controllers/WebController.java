package com.example.restapicurrenda.controllers;

import com.example.restapicurrenda.data.activePages;
import com.example.restapicurrenda.data.caseCount;
import com.example.restapicurrenda.models.*;
import com.example.restapicurrenda.services.CaseService;
import com.example.restapicurrenda.services.PartyService;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@RestController
public class WebController {

    private CaseService caseService;
    private PartyService partyService;

    public WebController(CaseService caseService, PartyService partyService){
        this.caseService = caseService;
        this.partyService = partyService;
    }
    @GetMapping("/")
    public PostResponse getLandingPage(){
        PostResponse response = new PostResponse();
        response.setMessage("Hello. You can start quering CaseEntity and PartyEntity data.");
        response.setExtra("Please read README.md for detailed information.");
        return response;
    }

    @GetMapping("/case/list")
    public Iterable<CaseEntity> list(){
        return caseService.list();
    }

    @GetMapping("/party/list")
    public Iterable<PartyEntity> list2(){
        return partyService.list();
    }

    @GetMapping("/case/getBetweenAndType")
    public Iterable<caseCount> findAllBetweenAndType(@RequestParam(value = "start") Optional<String> start, @RequestParam(value = "end") Optional<String> end, @RequestParam(value = "type") Optional<String> type){
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
         Date startDate = new Date();
         Date endDate = new Date();
         String typeValue = new String();
         try {
             startDate = start.isPresent() ? formatter.parse(start.get()) : new Date("1970-01-01");
             endDate = end.isPresent() ? formatter.parse(end.get()) : new Date();
             typeValue = type.isPresent() ? type.get() : null;
         }
         catch (Exception e){
             startDate = new Date(1970);
             endDate = new Date();
             typeValue = null;
         }
        return caseService.findAllBetweenAndType(startDate, endDate, typeValue);
    }

    @GetMapping("/address/getActiveForState")
    public Iterable<activePages> findActiveForState(@RequestParam(value="state") Optional<String> state){
        String caseValue = state.isPresent() ? state.get() : null;
        return partyService.findAllActiveForCaseState(caseValue);
    }
}
