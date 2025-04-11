package com.iticbcn.mywebapp.llibresApp.Repositoris;

import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Subcategoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Object,Long> {
    
   // List<Subcategoria>

    
} 