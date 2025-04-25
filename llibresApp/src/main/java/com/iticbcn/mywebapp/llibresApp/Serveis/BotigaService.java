package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;

public interface BotigaService {
    List<CategoriaDTO> findAllCategorias();
    Optional<CategoriaDTO> findCategoriaById(Long id);
    CategoriaDTO saveCategoria(CategoriaDTO entity);
    void deleteCategoriaById(Long id); 

    List<ProductDTO> findAllProducts();
    Optional<ProductDTO> findProductById(Long id);
    ProductDTO saveProduct(ProductDTO entity);
    void deleteProductBy(Long id); 

    //TODO: Subcategoria
    List<SubcategoriaDTO> findAllSubcategorias();
    Optional<SubcategoriaDTO> findSubCategoriaById(Long id);
    SubcategoriaDTO savedSubcategoria(SubcategoriaDTO entity);
    void deleteSubcategoriaId(Long id);
}