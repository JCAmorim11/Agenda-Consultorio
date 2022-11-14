package br.com.medicalClinic.agenda.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tblPacientes")
public class Pacient {

    @Column(name="nome")
    private String name;

    @Column(name="cpf")
    private String cpf;

    @Column(name="telefone")
    private String telephone;

    @OneToMany(
        mappedBy = "usuario",
        fetch = FetchType.LAZY,
        cascade = CascadeType.MERGE,
        orphanRemoval = true
    )
    private List<Appointment> appointments;
}
