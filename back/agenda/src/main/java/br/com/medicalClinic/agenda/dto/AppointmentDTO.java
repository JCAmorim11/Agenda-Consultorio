package br.com.medicalClinic.agenda.dto;


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

    private String status;
}
