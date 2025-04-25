package com.iticbcn.mywebapp.llibresApp.Serveis;

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
import com.iticbcn.mywebapp.llibresApp.Mapper.ProductMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.ProductRepository;

@Service
public class ProductServiceImpl implements BotigaService {
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    private CategoriaServiceImpl categoriaServiceImpl;

    private SubcategoriaServiceImpl subcategoriaServiceImpl;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
            CategoriaServiceImpl categoriaServiceImpl, SubcategoriaServiceImpl subcategoriaServiceImpl) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoriaServiceImpl = categoriaServiceImpl;
        this.subcategoriaServiceImpl = subcategoriaServiceImpl;
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
        Optional<Categoria> categoria = categoriaServiceImpl.findBydescCategoria(entity.getDesc_Categoria());
        
        Optional<Subcategoria> subcategoria= subcategoriaServiceImpl.findByDescSubcategoria(entity.getDesc_Subcategoria());
        if (!categoria.isPresent()) {
            throw new IllegalArgumentException("La categoria no existeix.");
        }
        if (!subcategoria.isPresent()) {
            throw new IllegalArgumentException("La subcategoria no existeix.");
        }
        Product producte = productMapper.ProductDTOtoProduct(entity);
        producte.setCreationDate(LocalDateTime.now());
        producte.setUpdateDate(LocalDateTime.now());
        producte.setCategoria(categoria.get());
        producte.setSubcategoria(subcategoria.get());
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

    public void modificarPreu(String nom, float nouPreu) {
        Optional<ProductDTO> productOpt = findProductByName(nom);
        if (productOpt.isPresent()) {
            LocalDateTime data = LocalDateTime.now();
            productRepository.modificarPreu(nom, nouPreu, data);
        } else {
            throw new IllegalArgumentException("El producte amb nom " + nom + " no existeix.");
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
