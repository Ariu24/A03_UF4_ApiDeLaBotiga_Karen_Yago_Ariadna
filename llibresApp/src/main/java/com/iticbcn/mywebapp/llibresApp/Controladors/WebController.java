package com.iticbcn.mywebapp.llibresApp.Controladors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.Serveis.CategoriaServiceImpl;
import com.iticbcn.mywebapp.llibresApp.Serveis.ProductServiceImpl;
import com.iticbcn.mywebapp.llibresApp.Serveis.SubcategoriaServiceImpl;

import org.springframework.web.bind.annotation.RequestBody; 

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/botiga")
public class WebController {
 
    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private SubcategoriaServiceImpl subcategoriaServiceImpl;

    @PostMapping("/inserirCategoria")
    public String inserirCategoria(@RequestBody CategoriaDTO categoriaDTO){
        System.out.println("DESC1: "+categoriaDTO.getDescCategoria());
        categoriaServiceImpl.saveCategoria(categoriaDTO);
        return "Categoria inserida correctament";
    }

    @GetMapping("/LlistarCategories") 
    public List<CategoriaDTO> consulta() {
        List<CategoriaDTO> categorias = categoriaServiceImpl.findAllCategorias();
        return categorias;
    }

    @PostMapping("/inserirProducte")
    public String inserirProducte(@RequestBody ProductDTO producteDTO){
        productServiceImpl.saveProduct(producteDTO);
        return "Producte inserit correctament";
    }
    @GetMapping("/LlistarProductes") 
    public List<ProductDTO> buscar() {
        List<ProductDTO> productes = productServiceImpl.findAllProducts();
        return productes;
    }
    @GetMapping("/CercaProductes") 
    public Optional<ProductDTO> buscarProducte(@RequestParam String nom) {
        Optional<ProductDTO> productes = productServiceImpl.findProductByName(nom);
        return productes;
    }
    
    @PostMapping("/inserirSubcategoria")
    public String inserirsubCategoria(@RequestBody SubcategoriaDTO subcategoriaDTO){
        productServiceImpl.savedSubcategoria(subcategoriaDTO);
        return "Producte inserit correctament";
    }
    @GetMapping("/LlistaSubcategoria")
    public List<SubcategoriaDTO>recerca(){
        List<SubcategoriaDTO> subcategorias = subcategoriaServiceImpl.findAllSubcategorias();
        return subcategorias;

    }
    


}
