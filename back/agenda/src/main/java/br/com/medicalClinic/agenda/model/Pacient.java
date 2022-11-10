package br.com.medicalClinic.agenda.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PACIENTES")
public class Pacient extends Base{

    private String name;
    private String cpf;
    private String telephone;

    @OneToMany(
        mappedBy = "usuario",
        fetch = FetchType.LAZY,
        cascade = CascadeType.MERGE,
        orphanRemoval = true
    )
    private List<Appointment> appointments;
}
