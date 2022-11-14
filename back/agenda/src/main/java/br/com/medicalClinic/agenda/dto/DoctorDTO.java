package br.com.medicalClinic.agenda.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {



    private String name;

    private String CRM;


    private String specialty;
}
