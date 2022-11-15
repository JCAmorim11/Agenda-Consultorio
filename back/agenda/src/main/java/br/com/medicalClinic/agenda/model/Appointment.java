package br.com.medicalClinic.agenda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblConsultas")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name="fk_paciente",nullable = false)
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name="fk_medico",nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="fk_consultorio",nullable = false)
    private Office office;

    @Column(name="data_consulta")
    private LocalDateTime dateTime;

    @Column(name="status")
    private String status;
}

