package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoriaMapper {
    
    SubcategoriaDTO SubcategoriaToSubcategoriaDTO(Subcategoria subcategoria);
    Subcategoria SubcategoriaDTOToSubcategoria(SubcategoriaDTO SubcategoriaDTO);

    Set<Subcategoria> SubcategoriaDTOToSubcategorias(Set<SubcategoriaDTO> llibresDTO);
    Set<SubcategoriaDTO> SubcategoriaToSubcategoriaDTO(Set<Subcategoria> llibres);
   

    
} 