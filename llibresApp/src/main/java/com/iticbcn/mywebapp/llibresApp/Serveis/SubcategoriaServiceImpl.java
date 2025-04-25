package com.iticbcn.mywebapp.llibresApp.Serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class SubcategoriaServiceImpl implements BotigaService {
    
    private SubcategoriaRepository subcategoriaRepository;

    private SubcategoriaMapper subcategoriaMapper;

@Autowired
private CategoriaServiceImpl categoriaServiceImpl;
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
    public Optional<SubcategoriaDTO> findSubCategoriaById(Long id){
        Optional<Subcategoria> c = subcategoriaRepository.findById(id);
        if (c.isPresent()){
            return Optional.of(subcategoriaMapper.SubcategoriaToSubcategoriaDTO(c.get()));
        }
        return Optional.empty();
    }

    @Override
    public SubcategoriaDTO savedSubcategoria(SubcategoriaDTO subcategoriaDTO) {
        Subcategoria subcategoria = subcategoriaMapper.SubcategoriaDTOtoSubcategoria(subcategoriaDTO);
        Optional<Categoria> categoriaExistente = categoriaServiceImpl.findBydescCategoria(subcategoriaDTO.getDescCategoria());  
        if (!categoriaExistente.isPresent()) {
            throw new RuntimeException("La categoría con descripción '" + subcategoriaDTO.getDescCategoria() + "' no existe.");
        }   
        subcategoria.setCategoria(categoriaExistente.get());
        subcategoria.setCreation_at(LocalDateTime.now());
        subcategoria.setStatus_Subcategoria("Actiu");
        Subcategoria savedSubcategoria = subcategoriaRepository.save(subcategoria);
        return subcategoriaMapper.SubcategoriaToSubcategoriaDTO(savedSubcategoria);
    }
    

    @Override
    public void deleteSubcategoriaId(Long id){
        subcategoriaRepository.deleteById(id);
    }
    
    public Optional<Subcategoria> findByDescSubcategoria(String desc) {
        return subcategoriaRepository.findByDescSubcategoria(desc);
    }

    public Optional<SubcategoriaDTO> findBydescSubcategoriaDTO(String descSubcategoria){
        Optional<Subcategoria> subcategoria= subcategoriaRepository.findByDescSubcategoria(descSubcategoria);
        if(subcategoria.isPresent()){
            return Optional.of((subcategoriaMapper.SubcategoriaToSubcategoriaDTO(subcategoria.get())));
        }
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> findAllProducts(){
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }
    @Override
    public Optional<ProductDTO> findProductById(Long id){
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }
    @Override
    public ProductDTO saveProduct(ProductDTO entity){
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    
    }

    @Override
    public void deleteProductById(Long id){
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }

    @Override
    public List<CategoriaDTO> findAllCategorias() {
        throw new UnsupportedOperationException("Este método debe implementarse en CategoriaServiceImp");
    }

    @Override
    public Optional<CategoriaDTO> findCategoriaById(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en CategoriaServiceImp");
    }

    @Override
    public CategoriaDTO saveCategoria(CategoriaDTO entity) {
        throw new UnsupportedOperationException("Este método debe implementarse en CategoriaServiceImp");
    }

    @Override
    public void deleteCategoriaById(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en CategoriaServiceImp");
    }
    
}
