package com.iticbcn.mywebapp.llibresApp.DTO;


import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private String company;
    private float price;
    private long units;
    private String desc_Categoria;
    private String desc_Subcategoria;
}
