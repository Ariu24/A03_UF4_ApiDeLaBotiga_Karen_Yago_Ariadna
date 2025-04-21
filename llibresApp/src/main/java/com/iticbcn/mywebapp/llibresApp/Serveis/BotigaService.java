package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;

public interface BotigaService {
 
    List<Object> findAll();
    Optional<Object> findByID(Long id);
    Object save(Object obj);
    void deleteById(Long id);

    //TODO: Subcategoria
    List<SubcategoriaDTO> findAllSubcategorias();
    Optional<SubcategoriaDTO> findSubCategoriaById(Long id);
    SubcategoriaDTO savedSubcategoria(SubcategoriaDTO entity);
    void deleteSubcategoriaId(Long id);
}
