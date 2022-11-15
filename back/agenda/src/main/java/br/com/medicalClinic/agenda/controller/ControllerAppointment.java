package br.com.medicalClinic.agenda.controller;


import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/consultas")
public class ControllerAppointment extends ControllerBase<AppointmentDTO> {

    @Autowired
    AppointmentService appointmentService;

   @GetMapping("/all")
    public ResponseEntity<?> getAllAppointments(){
       return ResponseEntity.status(HttpStatus.OK).body(this.appointmentService.listAppointments());
    }

    @PostMapping("/criarConsulta")
    @Transactional
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO dto){
        this.appointmentService.createAppointment(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/atualizarConsulta")
    @Transactional
    public ResponseEntity<?> alterAppointment(@RequestBody AppointmentDTO dto){
       this.appointmentService.updateAppointment(dto);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cancelarConsulta")
    @Transactional
    public ResponseEntity<?> cancelAppointment(@RequestBody AppointmentDTO dto){
        this.appointmentService.cancelAppointment(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
