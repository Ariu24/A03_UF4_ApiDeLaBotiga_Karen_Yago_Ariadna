package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    // Mètodes de mapeig
    @Mapping(source = "categoria.descCategoria", target = "desc_Categoria")
    @Mapping(source = "subcategoria.descSubcategoria", target = "desc_Subcategoria")
    ProductDTO ProductToProductDTO(Product product);
 
    @Mapping(source = "desc_Categoria", target = "categoria.descCategoria")
    @Mapping(source = "desc_Subcategoria", target = "subcategoria.descSubcategoria")
    Product ProductDTOtoProduct(ProductDTO productDTO);
 
    Set<Product> ProductDTOstoProducts(Set<ProductDTO> llibresDTO);
    Set<ProductDTO> ProductsTOProductsDTOs(Set<Product> llibres);     
}
