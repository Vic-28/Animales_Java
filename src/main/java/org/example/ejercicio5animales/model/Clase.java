package org.example.ejercicio5animales.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Clase")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @NotNull(message = "Clase no puede estar vacio")
    @Size(min = 3, max = 15, message="El nombre debe tener entre 3 y 15 caracteres")
    @Column(name = "nombreClase")
    private String nombreClase;

    public Clase(int id, String nombreClase)
    {
        this.id=id;
        this.nombreClase=nombreClase;

    }

    public Clase() {

    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}
    public String getNombreClase(){return nombreClase ;}

}
