package com.iticbcn.mywebapp.llibresApp.Serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import com.iticbcn.mywebapp.llibresApp.Mapper.SubcategoriaMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.SubcategoriaRepository;

@Service
public class SubcategoriaImpl implements BotigaService {
    
    private SubcategoriaRepository subcategoriaRepository;

    private SubcategoriaMapper subcategoriaMapper;

    @Autowired
    public SubcategoriaServiceImpl(SubcategoriaRepository subcategoriaRepository, SubcategoriaMapper subcategoriaMapper){
        this.subcategoriaRepository = subcategoriaRepository;
        this.subcategoriaMapper = subcategoriaMapper;
    }

    @Override
    public List<SubcategoriaDTO> findAllSubcategorias() {
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        List<SubcategoriaDTO> subcategoriaDTOs = new ArrayList<>();
        for(Subcategoria c : subcategorias){
            subcategoriaDTOs.add(subcategoriaMapper.SubcategoriaToSubcategoriaDTO(c));
        }
        return subcategoriaDTOs;   
    }

    @Override
    public Optional<SubcategoriaDTO> findSubcategoriaById(Long id){
        Optional<Subcategoria> c = subcategoriaRepository.findById(id);
        if (c.isPresent()){
            return Optional.of(subcategoriaMapper.SubcategoriaToSubcategoriaDTO(c.get()));
        }
        return Optional.empty();
    }

    @Override
    public SubcategoriaDTO saveSubcategoria(SubcategoriaDTO subcategoriaDTO){
        Subcategoria subcategoria = subcategoriaMapper.SubcategoriaDTOtoSubcategoria(subcategoriaDTO);
        Subcategoria savedSubcategoria = subcategoriaRepository.save(subcategoria);
        return subcategoriaMapper.SubcategoriaToSubcategoriaDTO(savedSubcategoria);

    }

    @Override
    public void deleteSubcategoriaById(Long id){
        subcategoriaRepository.deleteById(id);
    }

    public List<SubcategoriaDTO> findByTextIgnoreCase(String text){
        
    }
    


}
