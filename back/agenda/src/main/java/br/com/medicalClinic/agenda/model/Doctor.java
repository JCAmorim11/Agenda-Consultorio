package br.com.medicalClinic.agenda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblMedicos")
public class Doctor {

    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="CRM")
    private String CRM;

    @Column(name="especialidade")
    private String specialty;
}
