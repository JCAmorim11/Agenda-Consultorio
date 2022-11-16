package br.com.medicalClinic.agenda.service;

import br.com.medicalClinic.agenda.converter.AppointmentConverter;
import br.com.medicalClinic.agenda.dto.AppointmentDTO;
import br.com.medicalClinic.agenda.model.Appointment;
import br.com.medicalClinic.agenda.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
       return sortDates(returnList);
    }

    public List<AppointmentDTO> sortDates(List<AppointmentDTO> appointments){
        return appointments.stream().sorted(Comparator.comparing(AppointmentDTO::getDateTime, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());
    }

    public List<AppointmentDTO> findSameDate(LocalDate date){
       List<Appointment> appointments = this.repository.findAll();
       List<AppointmentDTO> dto = new ArrayList<>();
       for(Appointment appointment: appointments){
           dto.add(appointmentConverter.converterEntityToDTO(appointment));
       }
       List<AppointmentDTO> dtoSort = new ArrayList<>();
       for(AppointmentDTO apnt: dto){
           if(isSameDay(apnt.getDateTime(), date)){
               dtoSort.add(apnt);
           }
       }
       return dtoSort;

    }
    public List<AppointmentDTO> findSameDate(LocalDate date, LocalTime time){
        LocalDateTime dt = LocalDateTime.of(date, time);
        List<Appointment> appointments = this.repository.findAll();
        List<AppointmentDTO> dto = new ArrayList<>();
        for(Appointment appointment: appointments){
            dto.add(appointmentConverter.converterEntityToDTO(appointment));
        }
        List<AppointmentDTO> dtoSort = new ArrayList<>();
        for(AppointmentDTO apnt: dto){
           if(isSameDaytime(apnt.getDateTime(), dt)){
               dtoSort.add(apnt);
           }
        }
        return dtoSort;

    }

    public static boolean isSameDaytime(LocalDateTime appointmentDate, LocalDateTime timestampToCompare) {
        return appointmentDate.truncatedTo(ChronoUnit.DAYS)
                .isEqual(timestampToCompare.truncatedTo(ChronoUnit.DAYS));
    }

    public static boolean isSameDay(LocalDateTime appointmentDate, LocalDate givenDate) {
        return appointmentDate.toLocalDate().isEqual(givenDate);
    }
}
