package br.com.medicalClinic.agenda.repository;

import br.com.medicalClinic.agenda.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.appointmentNumber = :number")
    Optional<Appointment> findByAppointmentNumber(@Param("number") Long number);
}
