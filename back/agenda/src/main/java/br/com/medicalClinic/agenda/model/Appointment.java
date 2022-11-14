package br.com.medicalClinic.agenda.model;


import br.com.medicalClinic.agenda.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblConsultas")
public class Appointment {

    @Column()
    private Pacient pacient;

    @Column()
    private Doctor doctor;
    @Column()
    private Office office;
    @Column()
    private LocalDateTime dateTime;

    @Column(name="status")
    private AppointmentStatus status;
}

