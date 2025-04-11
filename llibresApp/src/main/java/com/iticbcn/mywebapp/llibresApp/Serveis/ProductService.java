package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;
import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;

public interface ProductService {
 
    List<Product> findAllProducts();
    Product findProductsByName(String name);
    //Product findProductsByCompany(String name);
    List<Product> findAllProducts(String subcategory);
    void increasePrice(Product product);
}
