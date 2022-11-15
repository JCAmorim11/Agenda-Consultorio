package br.com.medicalClinic.agenda.converter;

import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;

import br.com.medicalClinic.agenda.model.Office;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter {
    @Autowired
    private DoctorConverter doctorConverter;
    @Autowired
    private PacientConverter pacientConverter;
    @Autowired
    private OfficeConverter officeConverter;

    public Appointment converterDtoToEntity(AppointmentDTO dto) {
        return Appointment.builder()
                .pacient(pacientConverter.converterDtoToEntity(dto.getPacient()))
                .doctor(doctorConverter.converterDtoToEntity(dto.getDoctor()))
                .office(officeConverter.converterDtoToEntity(dto.getOffice()))
                .dateTime(dto.getDateTime())
                .status(dto.getStatus())
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
