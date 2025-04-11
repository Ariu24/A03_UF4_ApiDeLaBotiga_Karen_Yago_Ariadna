package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.iticbcn.mywebapp.llibresApp.Repositoris.CategoriaRepository;

public class CategoriaServiceImpl implements BotigaService {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Object> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Object> findByID(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Object save(Object obj) {
        return categoriaRepository.save(obj);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.delete(id);
    }
    
}
