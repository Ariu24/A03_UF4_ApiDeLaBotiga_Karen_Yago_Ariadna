package com.iticbcn.mywebapp.llibresApp.DTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
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
    
}
