package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD:llibresApp/src/main/java/com/iticbcn/mywebapp/llibresApp/Serveis/ProductService.java
public interface ProductService {
  
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Set<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);
=======
public interface BotigaService {
 
    List<Object> findAll();
    Optional<Object> findByID(Long id);
    Object save(Object obj);
    void deleteById(Long id);
>>>>>>> 93742ca147d00978ba746ac8ca20c5eb3bb63c23:llibresApp/src/main/java/com/iticbcn/mywebapp/llibresApp/Serveis/BotigaService.java

    /*  List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id); */
   
}
