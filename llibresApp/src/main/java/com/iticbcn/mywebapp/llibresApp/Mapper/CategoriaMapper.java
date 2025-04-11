package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {
    CategoriaDTO CategoriaToCategoriaDTO(Categoria categoria);
 
    Categoria CategoriaDTOtoCategoria(CategoriaDTO categoriaDTO);
 
    List<Categoria> CategoriasDTOToCategorias(List<CategoriaDTO> llibresDTO);
    List<CategoriaDTO> CategoriasToCategoriasDTO(List<Categoria> llibres);     
}
