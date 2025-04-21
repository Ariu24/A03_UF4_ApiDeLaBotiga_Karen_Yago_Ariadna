package com.iticbcn.mywebapp.llibresApp.DomainModel;

import java.security.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="category")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Categoria")
    private Long id_Categoria ;
    @Column(nullable = false)
    private String desc_Categoria;
    @Column(nullable = false)
    private String status_Categoria;
    @Column(nullable = false)
    private Timestamp creation_at;
    @Column(nullable = false)
    private Timestamp updated_at ;
    @Column(nullable = false)
    private Subcategoria subcategoria;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

