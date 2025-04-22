package com.iticbcn.mywebapp.llibresApp.Repositoris;

import org.springframework.stereotype.Repository;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findBystatus(String status);
    Optional<Categoria> findBydescCategoria(String descCategoria);
}