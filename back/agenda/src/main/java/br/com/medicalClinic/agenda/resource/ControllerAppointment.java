package br.com.medicalClinic.agenda.resource;


import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
@RequestMapping("/agendar")
public class ControllerAppointment extends ControllerBase<AppointmentDTO> {

    @Autowired
    AppointmentService appointmentService;

   @GetMapping("/consultas")
    public ResponseEntity<?> getAllAppointments(){

       return null;
    }

    @PostMapping("criarConsulta")
    public ResponseEntity<?> createAppointment(){
        return null;
    }

    @PutMapping("/atualizarConsulta")
    public ResponseEntity<?> alterAppointment(){

        return null;
    }

}
