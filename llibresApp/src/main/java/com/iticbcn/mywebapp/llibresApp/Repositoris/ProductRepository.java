package com.iticbcn.mywebapp.llibresApp.Repositoris;


import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Object, Long> {
    @Override
    @NonNull
    List<Object> findAll();
    Object findProductsByName(String name);
    List<Object> findAllProducts();
}

