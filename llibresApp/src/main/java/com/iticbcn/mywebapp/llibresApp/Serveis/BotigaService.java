package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;

public interface BotigaService {
 
    List<Object> findAllProducts();
    Object findProductsByName(String name);
    List<Object> findAllProducts(String subcategory);
    void increasePrice(Object obj);
}