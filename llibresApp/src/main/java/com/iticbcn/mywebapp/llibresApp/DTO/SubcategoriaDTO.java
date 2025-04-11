package com.iticbcn.mywebapp.llibresApp.DTO;

import java.security.Timestamp;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoriaDTO {

    private String desc_Subcategoria;
    
    private String status_Subcategoria;

    private Categoria categoria;

    private Product product;
    
}
