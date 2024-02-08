package org.example.ejercicio5animales.repository;

import org.example.ejercicio5animales.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

}
