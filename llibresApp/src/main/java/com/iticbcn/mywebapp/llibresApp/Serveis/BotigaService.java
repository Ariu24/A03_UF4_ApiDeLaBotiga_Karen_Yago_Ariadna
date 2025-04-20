package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.List;
import java.util.Optional;

public interface BotigaService {
    List<Object> findAll();
    Optional<Object> findByID(Long id);
    void save(Object obj);
    void deleteById(Long id);

    /*  List<T> findAll();
    Optional<T> findById(ID id);
    T save(T entity);
    void deleteById(ID id); */
   
}
