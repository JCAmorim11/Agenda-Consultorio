package br.com.medicalClinic.agenda.converter;

import br.com.medicalClinic.agenda.dto.PacientDTO;
import br.com.medicalClinic.agenda.model.Pacient;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PacientConverter {

    public Pacient converterDtoToEntity(PacientDTO dto) {
        return Pacient.builder()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .telephone(dto.getTelephone())
                .build();
    }

    public PacientDTO converterEntityToDTO(Pacient entity){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Pacient, PacientDTO>(){
            @Override
            protected void configure(){
            }
        });
        return modelMapper.map(entity, PacientDTO.class);
    }
}
