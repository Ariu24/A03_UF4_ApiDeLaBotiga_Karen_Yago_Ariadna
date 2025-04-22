package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import com.iticbcn.mywebapp.llibresApp.Mapper.CategoriaMapper;
import com.iticbcn.mywebapp.llibresApp.Mapper.CategoriaMapperImpl;
import com.iticbcn.mywebapp.llibresApp.Mapper.ProductMapper;
import com.iticbcn.mywebapp.llibresApp.Mapper.SubcategoriaMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.ProductRepository;
import com.iticbcn.mywebapp.llibresApp.Repositoris.SubcategoriaRepository;

@Service
public class ProductServiceImpl implements BotigaService {
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    private CategoriaServiceImpl categoriaServiceImpl;
    private CategoriaMapper categoriaMapper;

    private SubcategoriaServiceImpl subcategoriaServiceImpl;
    private SubcategoriaMapper subcategoriaMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
            CategoriaServiceImpl categoriaServiceImpl, SubcategoriaServiceImpl subcategoriaServiceImpl, CategoriaMapper categoriaMapper,
            SubcategoriaMapper subcategoriaMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoriaServiceImpl = categoriaServiceImpl;
        this.subcategoriaServiceImpl = subcategoriaServiceImpl;
        this.categoriaMapper = categoriaMapper;
        this.subcategoriaMapper = subcategoriaMapper;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> productes = productRepository.findAll();
        List<ProductDTO> productesDTO = new ArrayList<>();
        for (Product producte : productes) {
            productesDTO.add(productMapper.ProductToProductDTO(producte));
        }
        return productesDTO;
    }

    @Override
    public Optional<ProductDTO> findProductById(Long id) {
        Optional<Product> producte = productRepository.findById(id);
        if (producte.isPresent()) {
            return Optional.of(productMapper.ProductToProductDTO(producte.get()));
        }
        return Optional.empty();
    }

    @Override
    public ProductDTO saveProduct(ProductDTO entity) {
        Long id = 1L;
        Optional<CategoriaDTO> categoria = categoriaServiceImpl.findCategoriaById(id);
        
        Optional<SubcategoriaDTO> subcategoria= subcategoriaServiceImpl.findSubCategoriaById(id);
        if (!categoria.isPresent()) {
            throw new IllegalArgumentException("La categoria no existeix.");
        }
        if (!subcategoria.isPresent()) {
            throw new IllegalArgumentException("La subcategoria no existeix.");
        }
        Product producte = productMapper.ProductDTOtoProduct(entity);
        producte.setCreationDate(LocalDateTime.now());
        producte.setUpdateDate(LocalDateTime.now());
        Categoria categoriaM = categoriaMapper.CategoriaDTOtoCategoria(categoria.get());
        Subcategoria subcat = subcategoriaMapper.SubcategoriaDTOtoSubcategoria(subcategoria.get());
        producte.setCategoria(categoriaM);
        producte.setSubcategoria(subcat);
        Product productGuardat = productRepository.save(producte);
        return productMapper.ProductToProductDTO(productGuardat);
    }

    @Override
    public void deleteProductById(Long id) {
        if (findProductById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }

    public Optional<ProductDTO> findProductByName(String nom) {
        Optional<Product> producte = productRepository.findProductByName(nom);
        if (producte.isPresent()) {
            return Optional.of(productMapper.ProductToProductDTO(producte.get()));
        }
        return Optional.empty();
    }

    public void modificarPreu(Long id, float nouPreu) {
        Optional<ProductDTO> productOpt = findProductById(id);
        if (productOpt.isPresent()) {
            
            productRepository.modificarPreu(id, nouPreu);
        } else {
            throw new IllegalArgumentException("El producte amb id " + id + " no existeix.");
        }
    }

    @Override
    public List<CategoriaDTO> findAllCategorias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllCategorias'");
    }

    @Override
    public Optional<CategoriaDTO> findCategoriaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCategoriaById'");
    }

    @Override
    public CategoriaDTO saveCategoria(CategoriaDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCategoria'");
    }

    @Override
    public void deleteCategoriaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategoriaById'");
    }

    @Override
    public List<SubcategoriaDTO> findAllSubcategorias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSubcategorias'");
    }

    @Override
    public Optional<SubcategoriaDTO> findSubCategoriaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSubCategoriaById'");
    }

    @Override
    public SubcategoriaDTO savedSubcategoria(SubcategoriaDTO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savedSubcategoria'");
    }

    @Override
    public void deleteSubcategoriaId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSubcategoriaId'");
    }

}
