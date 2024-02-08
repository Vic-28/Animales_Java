package org.example.ejercicio5animales.services;

import org.example.ejercicio5animales.interfaces.ClaseService;
import org.example.ejercicio5animales.model.Clase;
import org.example.ejercicio5animales.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceJpa implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Override
    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }

    @Override
    public Clase getClaseById(int id) {
        return claseRepository.findById(id).orElse(null);
    }
}
