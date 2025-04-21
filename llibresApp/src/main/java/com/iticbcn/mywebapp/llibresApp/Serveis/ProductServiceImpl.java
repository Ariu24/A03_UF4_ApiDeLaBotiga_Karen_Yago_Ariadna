package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import com.iticbcn.mywebapp.llibresApp.Mapper.CategoriaMapperImpl;
import com.iticbcn.mywebapp.llibresApp.Mapper.ProductMapper;
import com.iticbcn.mywebapp.llibresApp.Mapper.SubcategoriaMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.ProductRepository;
import com.iticbcn.mywebapp.llibresApp.Repositoris.SubcategoriaRepository;

public class ProductServiceImpl implements BotigaService {
    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    private CategoriaServiceImpl categoriaServiceImpl;

    private SubcategoriaServiceImpl subcategoriaServiceImpl;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoriaServiceImpl categoriaServiceImpl, SubcategoriaServiceImpl subcategoriaServiceImpl) {
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
        Categoria categoria = entity.getCategoria();
        Subcategoria subcategoryId = entity.getSubcategoria();
        if (!categoriaServiceImpl.findCategoriaById(categoria.getId_Categoria()).isPresent()) {
            throw new IllegalArgumentException("La categoria amb ID " + categoria.getId_Categoria() + " no existeix.");
        }
        if (!subcategoriaServiceImpl.findCategoriaById(subcategoryId.getId_Subategoria()).isPresent()) {
            throw new IllegalArgumentException("La subcategoria amb ID " + subcategoryId.getId_Subategoria() + " no existeix.");
        }
        Product producte = productMapper.ProductDTOtoProduct(entity);
        Product productGuardat = productRepository.save(producte);
        return productMapper.ProductToProductDTO(productGuardat);
    }

    @Override
    public void deleteProductById(Long id) {
        if(findProductById(id).isPresent()){
            productRepository.deleteById(id);
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
