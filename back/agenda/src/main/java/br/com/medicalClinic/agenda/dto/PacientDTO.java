package br.com.medicalClinic.agenda.dto;


import br.com.medicalClinic.agenda.model.Appointment;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacientDTO {

    private String name;

    private String cpf;

    private String telephone;

}
