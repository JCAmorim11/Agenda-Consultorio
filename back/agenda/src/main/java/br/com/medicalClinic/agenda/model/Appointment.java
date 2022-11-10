package br.com.medicalClinic.agenda.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    private Pacient pacient;
    private Doctor doctor;
    private Office office;
    private LocalDateTime dateTime;

    private String status;
}
