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
@Table(name = "tblpacientes")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="nome")
    private String name;

    @Column(name="cpf")
    private String cpf;

    @Column(name="telefone")
    private String telephone;


}
