package br.com.medicalClinic.agenda.dto;


import br.com.medicalClinic.agenda.enums.AppointmentStatus;
import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDTO {

    private PacientDTO pacient;

    private DoctorDTO doctor;

    private OfficeDTO office;

    private LocalDateTime dateTime;

    private AppointmentStatus status;
}
