package com.example.restapicurrenda.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class CaseEntity {

    @Id
    @GeneratedValue
    @Column(name ="case_id")
            private Long caseId;
    private String caseNumber;
    private String caseType;
    private String caseState;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfEntry;


    public CaseEntity()
    {

    }
}
