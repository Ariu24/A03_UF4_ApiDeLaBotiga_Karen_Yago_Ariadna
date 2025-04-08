package com.iticbcn.mywebapp.llibresApp.Serveis;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mywebapp.llibresApp.DomainModel.Llibre;
import com.iticbcn.mywebapp.llibresApp.Mapper.LlibreMapper;
import com.iticbcn.mywebapp.llibresApp.Repositoris.Repositori;
import com.iticbcn.mywebapp.llibresApp.DTO.LlibreDTO;

@Service
public class ProductServiceImpl implements ProductService {

    private Repositori repo;
    private LlibreMapper mapper;
    @Autowired
    public ProductServiceImpl(Repositori repo, LlibreMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }
    

    @Override
    public Set<LlibreDTO> findAll() {
        Set<Llibre> llibres = repo.findAll();
        Set<LlibreDTO> llibreDTO = mapper.LlibresToLlibresDTO(llibres);
        return llibreDTO;
    }

    @Override
    public LlibreDTO findByTitol(String titol) {
        Llibre llibre = repo.findByTitol(titol);
        return mapper.LlibreToLlibreDTO(llibre);
    }

    @Override
    public LlibreDTO findByTitolAndEditorial(String titol, String editorial) {
        Set<Llibre> llibres = repo.findByTitolAndEditorial(titol, editorial);
        return mapper.LlibreToLlibreDTO(llibres.iterator().next());
    }


    public boolean validarISBN(String isbn) {
        if (isbn == null || isbn.length() != 13) {
            return false;
        }
        String prefix = isbn.substring(0, 2);
        if (!prefix.matches("[A-Za-z]{2}")) {
            System.out.println("Las dos primeras posiciones del ISBN deben ser letras.");
            return false;
        }
        for (int i = 2; i < isbn.length(); i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                System.out.println("El ISBN debe contener solo números después de las dos primeras letras.");
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<LlibreDTO> findByIdLlibre(Long id_Llibre) {
        Optional<Llibre> llibre = repo.findById(id_Llibre);
        if (!llibre.isPresent()) {
            throw new NoSuchElementException("Llibre amb l'" + id_Llibre + " no existeix");
        }
        LlibreDTO llibreDTO = mapper.LlibreToLlibreDTO(llibre.get());
        return Optional.of(llibreDTO);
    }
    @Override
    public void save(LlibreDTO llibre) {
        repo.save(mapper.LlibreDTOToLlibre(llibre));
    }
}
