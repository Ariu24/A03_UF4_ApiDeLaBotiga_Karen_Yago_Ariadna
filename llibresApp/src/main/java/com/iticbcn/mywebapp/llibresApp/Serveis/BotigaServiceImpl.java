package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Product;
import com.iticbcn.mywebapp.llibresApp.Repositoris.ProductRepository;

public class BotigaServiceImpl implements BotigaService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Object> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Object> findByID(Long id) {
        return productRepository.findByID(id);
    }
    @Override
    public Object save(Object obj) {
        obj.save();
    }


    @Override
    public List<Product> findAllProducts(String subcategory) {
        return null;
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void increasePrice(Product product) {
        product.setPrice(product.getPrice()+10);

    }


    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
