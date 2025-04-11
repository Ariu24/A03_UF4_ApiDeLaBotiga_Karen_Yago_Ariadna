package com.iticbcn.mywebapp.llibresApp.DTO;

import java.security.Timestamp;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    private String desc_Categoria;

    private String status_Categoria;

    private Timestamp creation_at;

    private Timestamp updated_at ;

    private Subcategoria subcategoria;

    private Product product;
}

