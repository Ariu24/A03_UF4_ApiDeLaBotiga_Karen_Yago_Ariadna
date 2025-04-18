package com.iticbcn.mywebapp.llibresApp.DomainModel;

import java.security.Timestamp;

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
    private Long id_Subategoria;
    @Column
    private String desc_Subcategoria;
    @Column
    private String status_Subcategoria;
    @Column
    private Timestamp creation_at;
    @Column 
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @OneToMany
    @JoinColumn(name="product_id")
    private Product product;




}
