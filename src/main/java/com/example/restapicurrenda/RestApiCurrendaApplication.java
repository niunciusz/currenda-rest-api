package com.example.restapicurrenda;

import com.example.restapicurrenda.models.CaseEntity;
import com.example.restapicurrenda.models.PartyEntity;
import com.example.restapicurrenda.services.CaseService;
import com.example.restapicurrenda.services.PartyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class RestApiCurrendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCurrendaApplication.class, args);
	}

	/*
	Bean Runner
	Created for mapping json files into H2 database on runtime
	 */
	@Bean
	CommandLineRunner runner(CaseService caseService, PartyService partyService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CaseEntity>> typeReferenceCase = new TypeReference<List<CaseEntity>>(){};
			TypeReference<List<PartyEntity>> typeReferenceParty = new TypeReference<List<PartyEntity>>(){};
			InputStream inputStreamCase = TypeReference.class.getResourceAsStream("/static/case_generated.json");
			InputStream inputStreamParty = TypeReference.class.getResourceAsStream("/static/party_generated.json");
			try {
				List<CaseEntity> cases = mapper.readValue(inputStreamCase,typeReferenceCase);
				caseService.load(cases);
				System.out.println("Cases Loaded!");
			} catch (IOException e){
				System.out.println("Unable to save cases: " + e.getMessage());
			}
			try {
				List<PartyEntity> parties = mapper.readValue(inputStreamParty,typeReferenceParty);
				partyService.load(parties);
				System.out.println("Parites Loaded!");
			} catch (IOException e){
				System.out.println("Unable to save parties: " + e.getMessage());
			}
		};
	}
}
