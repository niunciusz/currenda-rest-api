package com.example.restapicurrenda.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class AddressEmbedded {

    private Long id;
    private String city;
    private String postalCode;
    private String street;

    public AddressEmbedded()
    {

    }
}
