package com.iticbcn.mywebapp.llibresApp.Repositoris;


import org.springframework.stereotype.Repository;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    @NonNull
    Set<Product> findAll();
    Product findByName(String name);
    Set<Product> findByNameAndPrice(String name, float price);
}

