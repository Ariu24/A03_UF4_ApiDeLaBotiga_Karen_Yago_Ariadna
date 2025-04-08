package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
 
public interface ProductService{
    Set<LlibreDTO> findAll();
    LlibreDTO findByTitol(String titol);
    LlibreDTO findByTitolAndEditorial(String titol, String Editorial);
    void save(LlibreDTO llibreDTO);
    Optional<LlibreDTO> findByIdLlibre(Long idLlibre);
}
 