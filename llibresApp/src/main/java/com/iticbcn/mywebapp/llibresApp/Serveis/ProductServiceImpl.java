package com.iticbcn.mywebapp.llibresApp.Serveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.Repositoris.ProductRepository;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Set<Product> findAllProducts(String subcategory) {
        return null;
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void increasePrice(Product product) {

    }
}

