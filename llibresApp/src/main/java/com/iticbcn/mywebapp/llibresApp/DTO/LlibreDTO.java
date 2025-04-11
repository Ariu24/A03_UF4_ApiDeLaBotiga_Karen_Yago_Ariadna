package com.iticbcn.mywebapp.llibresApp.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LlibreDTO {
    private Long idLlibre;
    private String titol;
    private String autor;
    private String editorial;
    private LocalDate datapublicacio;
    private String tematica;
    private String isbn;
}


