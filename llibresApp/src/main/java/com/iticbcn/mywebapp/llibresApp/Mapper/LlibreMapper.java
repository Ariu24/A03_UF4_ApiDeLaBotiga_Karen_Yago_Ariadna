package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.Set;
 
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
 
import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
 

//                injectar-o                 si no troba alguna propietat que no esta al dto o no vull que es mapeggi la ignora    

/* 
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LlibreMapper {
 
    LlibreDTO LlibreToLlibreDTO(Llibre llibre);
 
    Llibre LlibreDTOToLlibre(LlibreDTO llibreDTO);
 
    Set<Llibre> LlibresDTOToLlibres(Set<LlibreDTO> llibresDTO);
    Set<LlibreDTO> LlibresToLlibresDTO(Set<Llibre> llibres);     
}
    */
