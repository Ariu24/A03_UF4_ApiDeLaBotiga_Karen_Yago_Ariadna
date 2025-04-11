package com.iticbcn.mywebapp.llibresApp.Repositoris;

import org.springframework.stereotype.Repository;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Object, Long> {
    List<Categoria> findByStatus(String status);
}