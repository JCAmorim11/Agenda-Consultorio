package br.com.medicalClinic.agenda.model;

import br.com.medicalClinic.agenda.enums.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONSULTAS")
public class Appointment extends Base{

    private Pacient pacient;
    private Doctor doctor;
    private Office office;
    private LocalDateTime dateTime;

    private AppointmentStatus status;
}
