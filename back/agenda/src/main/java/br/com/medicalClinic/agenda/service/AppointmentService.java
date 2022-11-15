package br.com.medicalClinic.agenda.service;

import br.com.medicalClinic.agenda.converter.AppointmentConverter;
import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public void alterAppointment(){

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
