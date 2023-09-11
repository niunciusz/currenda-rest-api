package com.example.restapicurrenda.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class PartyEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private Long caseId;
    private String partyType;
    private String name;
    private Boolean active;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "party_addresses", joinColumns = @JoinColumn(name = "partyId"))
    private Set<AddressEmbedded> addresses = new HashSet<>();

    public PartyEntity()
    {

    }
}
