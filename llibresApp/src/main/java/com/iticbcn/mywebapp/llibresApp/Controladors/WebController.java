package com.iticbcn.mywebapp.llibresApp.Controladors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.mywebapp.llibresApp.DTO.CategoriaDTO;
import com.iticbcn.mywebapp.llibresApp.Serveis.CategoriaServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/botiga")
public class WebController {
 
    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    @PostMapping("/inserirCategoria")
    public String inserirCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaServiceImpl.saveCategoria(categoriaDTO);
        return "Categoria inserida correctament";
    }

    @GetMapping("/LlistarCategories") 
    public List<CategoriaDTO> consulta() {
        List<CategoriaDTO> categorias = categoriaServiceImpl.findAllCategorias();
        return categorias;
    }
}
