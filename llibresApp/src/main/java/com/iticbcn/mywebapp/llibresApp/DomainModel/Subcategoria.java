package com.iticbcn.mywebapp.llibresApp.DomainModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="subcategoria")
public class Subcategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Long id;
    @Column (name = "desc_Subcategoria")
    private String descSubcategoria;
    @Column (name = "status_Subcategoria")
    private String status_Subcategoria;
    @Column (name = "creation_at")
    private LocalDateTime creation_at;
    @Column (name = "updated_at")
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @OneToMany(mappedBy = "subcategoria")
    private List<Product> productes;

    public void addProduct(Product product) {
        productes.add(product);
        product.setSubcategoria(this);
    }

    public void removeProduct(Product product) {
        productes.remove(product);
        product.setSubcategoria(null);
    }
}
  
