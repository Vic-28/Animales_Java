package org.example.ejercicio5animales.services;

import org.example.ejercicio5animales.interfaces.AnimalService;
import org.example.ejercicio5animales.model.Animal;
import org.example.ejercicio5animales.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceJpalmpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public List<Animal> findAll (){ return animalRepository.findAll();};

    @Override
    public Animal getAnimalById(int id) {
        return animalRepository.findById(id).orElse(new Animal());
    }

    @Override
    public boolean deleteAnimal(int id)
    {
        animalRepository.deleteById(id);
        return false;
    }
    @Override
    public Animal addAnimal(Animal animal) {

        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }


}