package com.iticbcn.mywebapp.llibresApp.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductDTO ProductToProductDTO(Product product);
 
    Product ProductDTOtoProduct(ProductDTO productDTO);
 
    Set<Product> LlibresDTOToLlibres(Set<ProductDTO> llibresDTO);
    Set<ProductDTO> LlibresToLlibresDTO(Set<Product> llibres);     
}
