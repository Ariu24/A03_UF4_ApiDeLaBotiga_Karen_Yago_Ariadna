package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.Mapper.CategoriaMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements BotigaService {

    private CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper){
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaDTO> findAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTOs = new ArrayList<>();
        for(Categoria c : categorias){
            categoriaDTOs.add(categoriaMapper.CategoriaToCategoriaDTO(c));
        }
        return categoriaDTOs;
    }

    @Override
    public Optional<CategoriaDTO> findCategoriaById(Long id) {
        Optional<Categoria> c = categoriaRepository.findById(id);
        if (c.isPresent()) {
            return Optional.of(categoriaMapper.CategoriaToCategoriaDTO(c.get()));
        }
        return Optional.empty();
    }

    @Override
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.CategoriaDTOtoCategoria(categoriaDTO);
        categoria.setCreationAt(LocalDateTime.now());
        categoria.setStatus("Actiu");
        System.out.println("DESC2: "+categoria.getDescCategoria());
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.CategoriaToCategoriaDTO(savedCategoria);
    }

    @Override
    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaDTO> findByStatus(String status){
        List<Categoria> categorias = categoriaRepository.findBystatus(status);
        List<CategoriaDTO> categoriaDTOs = new ArrayList<>();
        for(Categoria c : categorias){
            categoriaDTOs.add(categoriaMapper.CategoriaToCategoriaDTO(c));
        }
        return categoriaDTOs;
    }

    public Optional<CategoriaDTO> findBydescCategoria(String descCategoria){
        Optional<Categoria> c = categoriaRepository.findBydescCategoria(descCategoria);
        if (c.isPresent()) {
            return Optional.of(categoriaMapper.CategoriaToCategoriaDTO(c.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }

    @Override
    public ProductDTO saveProduct(ProductDTO entity) {
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }

    @Override
    public void deleteProductById(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en ProductServiceImpl");
    }

    @Override
    public List<SubcategoriaDTO> findAllSubcategorias() {
        throw new UnsupportedOperationException("Este método debe implementarse en SubcategoriaServiceImpl");
    }

    @Override
    public Optional<SubcategoriaDTO> findSubCategoriaById(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en SubcategoriaServiceImpl");
    }

    @Override
    public SubcategoriaDTO savedSubcategoria(SubcategoriaDTO entity) {
        throw new UnsupportedOperationException("Este método debe implementarse en SubcategoriaServiceImpl");
    }

    @Override
    public void deleteSubcategoriaId(Long id) {
        throw new UnsupportedOperationException("Este método debe implementarse en SubcategoriaServiceImpl");
    }
}