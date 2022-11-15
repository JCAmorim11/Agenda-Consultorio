package br.com.medicalClinic.agenda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblMedicos")
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="nome")
    private String name;

    @Column(name="CRM")
    private String CRM;

    @Column(name="especialidade")
    private String specialty;
}
