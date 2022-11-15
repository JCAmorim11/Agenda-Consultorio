package br.com.medicalClinic.agenda.converter;

import br.com.medicalClinic.agenda.dto.DoctorDTO;
import br.com.medicalClinic.agenda.model.Doctor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class DoctorConverter {

    public Doctor converterDtoToEntity(DoctorDTO dto) {
        return Doctor.builder()
                .name(dto.getName())
                .CRM(dto.getCRM())
                .specialty(dto.getSpecialty())
                .build();
    }

    public DoctorDTO converterEntityToDTO(Doctor entity){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Doctor, DoctorDTO>(){
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, DoctorDTO.class);
    }
}
