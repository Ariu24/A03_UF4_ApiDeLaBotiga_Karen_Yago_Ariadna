package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

public interface BotigaService {
  
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Set<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);

/*  List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id); */
   
}
