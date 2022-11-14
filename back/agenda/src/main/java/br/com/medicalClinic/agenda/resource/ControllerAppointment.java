package br.com.medicalClinic.agenda.resource;


import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.service.AppointmentService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAppointment extends ControllerBase {

    AppointmentService appointmentService;
}
