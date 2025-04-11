package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
<<<<<<< HEAD

public interface BotigaService {
 
    List<Object> findAllProducts();
    Object findProductsByName(String name);
    List<Object> findAllProducts(String subcategory);
    void increasePrice(Object obj);
}
=======
import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

<<<<<<<< HEAD:llibresApp/src/main/java/com/iticbcn/mywebapp/llibresApp/Serveis/ProductService.java
public interface ProductService {
 
    List<Product> findAllProducts();
========
public interface BotigaService {
  
    Set<Product> findAllProducts();
>>>>>>>> e8abbad9a252d8a419a6fb352426f5b5e959cf6f:llibresApp/src/main/java/com/iticbcn/mywebapp/llibresApp/Serveis/BotigaService.java
    Product findProductsByName(String name);
    //Product findProductsByCompany(String name);
    List<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);

/*  List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id); */
   
}
>>>>>>> e8abbad9a252d8a419a6fb352426f5b5e959cf6f
