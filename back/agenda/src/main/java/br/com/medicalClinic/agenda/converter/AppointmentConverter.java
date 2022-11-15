package br.com.medicalClinic.agenda.converter;

import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class AppointmentConverter {

    public Appointment converterDtoToEntity(AppointmentDTO dto) {
        return Appointment.builder()
                .pacient(dto.getPacient())
                .doctor(dto.getDoctor())
                .value(dto.getValue())
                .destination(userService.checkEntity(dto.getDestiny().getLogin()))
                .origin(userService.checkEntity(dto.getOrigin().getLogin()))
                .build();
    }

    public AppointmentDTO converterEntityToDTO(Appointment entity){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Appointment, AppointmentDTO>() {
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, AppointmentDTO.class);
    }
}
