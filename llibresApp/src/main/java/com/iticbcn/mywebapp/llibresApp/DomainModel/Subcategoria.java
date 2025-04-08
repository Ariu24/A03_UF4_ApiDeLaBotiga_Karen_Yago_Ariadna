package com.iticbcn.mywebapp.llibresApp.DomainModel;
import java.io.Serializable;
import java.security.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Subcategoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Subategoria;
    @Column
    private String desc_Subcategoria;
    @Column
    private String status_Subcategoria;
    @Column
    private Timestamp creation_at;
    @Column 
    private Timestamp updated_at;


}
