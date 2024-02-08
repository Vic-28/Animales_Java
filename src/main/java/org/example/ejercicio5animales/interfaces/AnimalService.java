package org.example.ejercicio5animales.interfaces;

import org.example.ejercicio5animales.model.Animal;

import java.util.List;

public interface AnimalService {


    List<Animal> findAll ();


     Animal getAnimalById(int id);


    boolean deleteAnimal(int id);

     Animal addAnimal(Animal animal);


     Animal updateAnimal(Animal animal);

}