package br.com.medicalClinic.agenda.model;


import br.com.medicalClinic.agenda.dto.AppointmentDTO;
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
@Table(name = "tblconsultas")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="numero_consulta")
    private Long appointmentNumber;

    @ManyToOne(targetEntity = Pacient.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_paciente",nullable = false)
    private Pacient pacient;

    @ManyToOne(targetEntity = Doctor.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_medico",nullable = false)
    private Doctor doctor;

    @ManyToOne(targetEntity = Office.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name="fk_consultorio",nullable = false)
    private Office office;

    @Column(name="data_consulta")
    private LocalDateTime dateTime;

    @Column(name="status")
    private String status;

    public void updateRegistry(AppointmentDTO dto){
        this.dateTime = dto.getDateTime();
        this.status = dto.getStatus();
    }

}

