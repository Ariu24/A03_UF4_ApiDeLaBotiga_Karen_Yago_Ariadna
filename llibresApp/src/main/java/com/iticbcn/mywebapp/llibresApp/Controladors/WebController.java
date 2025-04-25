package com.iticbcn.mywebapp.llibresApp.Controladors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DTO.SubcategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;
import com.iticbcn.mywebapp.llibresApp.Serveis.CategoriaServiceImpl;
import com.iticbcn.mywebapp.llibresApp.Serveis.ProductServiceImpl;
import com.iticbcn.mywebapp.llibresApp.Serveis.SubcategoriaServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
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
        try{
            productServiceImpl.saveProduct(producteDTO);
            return "Producte inserit correctament";
        }catch(Exception e){
            return e.toString();
        }   
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
    public String inserirSubcategoria(@RequestBody SubcategoriaDTO subcategoriaDTO) {
        System.out.println("DESC Subcategoria: " + subcategoriaDTO.getDescSubcategoria());
        subcategoriaServiceImpl.savedSubcategoria(subcategoriaDTO);
        return "Subcategoria inserida correctament";
    }
    @PutMapping("/ModificarPreu")
    public String modificarPreu(@RequestParam String nom, @RequestParam float nouPreu) {
        try {
            productServiceImpl.modificarPreu(nom, nouPreu);
            return "Preu modificat correctament";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    @GetMapping("/LlistaSubcategoria")
    public List<SubcategoriaDTO>recerca(){
        List <SubcategoriaDTO> subcategorias = subcategoriaServiceImpl.findAllSubcategorias();
        return subcategorias;
    }

}
    
