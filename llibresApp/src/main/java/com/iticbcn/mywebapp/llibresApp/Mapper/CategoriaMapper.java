package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {
    CategoriaDTO CategoriaToCategoriaDTO(Categoria categoria);
 
    Categoria CategoriaDTOtoCategoria(CategoriaDTO categoriaDTO);
 
    Set<Categoria> CategoriasDTOToCategorias(Set<CategoriaDTO> llibresDTO);
    Set<CategoriaDTO> CategoriasToCategoriasDTO(Set<Categoria> llibres);     
}
