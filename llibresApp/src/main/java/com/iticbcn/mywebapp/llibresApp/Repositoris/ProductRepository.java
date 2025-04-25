package com.iticbcn.mywebapp.llibresApp.Repositoris;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import com.iticbcn.mywebapp.llibresApp.DTO.ProductDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String nom);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.price = :nouPreu, p.updateDate = :dataActualitzacio WHERE p.name = :name")
    void modificarPreu(@Param("name") String nom, @Param("nouPreu") float nouPreu,@Param("dataActualitzacio") LocalDateTime dataActualitzacio);
}
