package br.com.medicalClinic.agenda.service;

import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public void createAppointment(){

    }

    public void alterAppointment(){

    }

    public AppointmentDTO listAppointments(){
       List<Appointment> list = repository.findAll();
    }
}
