package com.iticbcn.mywebapp.llibresApp.DomainModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList; // Usaremos ArrayList para inicializar listas
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories") 
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") 
    private Long id; 

    @Column(name = "desc_categoria", nullable = false)
    private String descCategoria; 

    @Column(name = "status_categoria", nullable = false)
    private String status; 

    @Column(name = "creation_at", nullable = false)
    private LocalDateTime creationAt; 

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; 

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Subcategoria> subcategorias = new ArrayList<>(); 

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Product> productos = new ArrayList<>(); 

    public void addSubcategoria(Subcategoria subcategoria) {
        subcategorias.add(subcategoria);
        subcategoria.setCategoria(this);
    }

    public void removeSubcategoria(Subcategoria subcategoria) {
        subcategorias.remove(subcategoria);
        subcategoria.setCategoria(null);
    }

    public void addProduct(Product product) {
        productos.add(product);
        product.setCategoria(this);
    }

    public void removeProduct(Product product) {
        productos.remove(product);
        product.setCategoria(null);
    }
}