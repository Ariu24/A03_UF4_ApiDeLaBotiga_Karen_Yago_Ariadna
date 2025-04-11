package com.iticbcn.mywebapp.llibresApp.DomainModel;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

/*
 * id_Subategoria (Long).
desc_Subategoria (String).
status_Subategoria (String).
categoria.
creation_at (timestamp).
updated_at (timestamp).

 */

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


}
