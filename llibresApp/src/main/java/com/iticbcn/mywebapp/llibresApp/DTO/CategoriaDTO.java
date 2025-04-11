package com.iticbcn.mywebapp.llibresApp.DTO;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private String desc_Categoria;

    private String status_Categoria;

    private Subcategoria subcategoria;

    private Product product;
}

