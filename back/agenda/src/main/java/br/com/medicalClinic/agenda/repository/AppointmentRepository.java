package br.com.medicalClinic.agenda.repository;

import br.com.medicalClinic.agenda.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
