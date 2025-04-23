package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubcategoriaMapper {
    @Mapping(source = "categoria.descCategoria", target = "descCategoria")
    
    SubcategoriaDTO SubcategoriaToSubcategoriaDTO(Subcategoria subcategoria);
    Subcategoria SubcategoriaDTOtoSubcategoria(SubcategoriaDTO SubcategoriaDTO);

    List<Subcategoria> SubcategoriaDTOtoSubcategorias(List<SubcategoriaDTO> llibresDTO);
    List<SubcategoriaDTO> SubcategoriaToSubcategoriaDTO(List<Subcategoria> llibres);
   

    
} 