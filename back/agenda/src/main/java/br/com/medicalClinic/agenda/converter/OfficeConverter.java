package br.com.medicalClinic.agenda.converter;

import br.com.medicalClinic.agenda.dto.OfficeDTO;
import br.com.medicalClinic.agenda.dto.PacientDTO;
import br.com.medicalClinic.agenda.model.Office;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class OfficeConverter {
    public Office converterDtoToEntity(OfficeDTO dto){
        return Office.builder()
                .number(dto.getNumber())
                .build();
    }

    public OfficeDTO converterEntityToDTO(Office entity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Office, OfficeDTO>(){
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, OfficeDTO.class);
    }
}
