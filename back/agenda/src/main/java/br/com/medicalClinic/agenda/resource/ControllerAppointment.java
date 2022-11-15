package br.com.medicalClinic.agenda.resource;


import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendar")
public class ControllerAppointment extends ControllerBase<AppointmentDTO> {

    @Autowired
    AppointmentService appointmentService;
}
