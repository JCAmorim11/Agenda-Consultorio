package br.com.medicalClinic.agenda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblConsultorios")
public class Office {

    @Column(name="numero_consultorio")
    private String number;
    private List<Appointment> appointments;
}
