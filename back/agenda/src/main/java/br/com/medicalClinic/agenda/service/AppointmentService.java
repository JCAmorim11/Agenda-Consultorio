package br.com.medicalClinic.agenda.service;

import br.com.medicalClinic.agenda.converter.AppointmentConverter;
import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentConverter appointmentConverter;

    public void createAppointment(AppointmentDTO dto){
        Appointment neoAppointment = appointmentConverter.converterDtoToEntity(dto);
        this.repository.save(neoAppointment);

    }

    public void updateAppointment(AppointmentDTO dto){
        Optional<Appointment> appointment = this.repository.findByAppointmentNumber(dto.getAppointmentNumber());
        if(appointment.isPresent()) {
            appointment.get().updateRegistry(dto);
            this.repository.save(appointment.get());
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "não foi achado uma consulta correspondente");

    }
    public void cancelAppointment(AppointmentDTO dto){
        Optional<Appointment> appointment = this.repository.findByAppointmentNumber(dto.getAppointmentNumber());
        if(appointment.isPresent()) {
            appointment.get().setStatus("CANCELADA");
            this.repository.save(appointment.get());
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "não foi achado uma consulta correspondente");

    }

    public List<AppointmentDTO> listAppointments(){
       List<Appointment> list = repository.findAll();
       List<AppointmentDTO> returnList = new ArrayList<>();
       for(Appointment consulta: list){
           returnList.add(appointmentConverter.converterEntityToDTO(consulta));
       }
       return returnList;
    }
}
