package org.example.ejercicio5animales.interfaces;

import org.example.ejercicio5animales.model.Animal;
import org.example.ejercicio5animales.model.Clase;

import java.util.List;

public interface ClaseService {

    List<Clase>listarClases();

    Clase getClaseById(int id);

}
