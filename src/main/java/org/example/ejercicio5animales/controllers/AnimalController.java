package org.example.ejercicio5animales.controllers;

import org.example.ejercicio5animales.interfaces.AnimalService;
import org.example.ejercicio5animales.interfaces.ClaseService;
import org.example.ejercicio5animales.model.Animal;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/Animal")
public class AnimalController {

    private final AnimalService animalService;

    private final ClaseService claseService;

    public AnimalController(AnimalService animalService, ClaseService claseService) {
        this.animalService = animalService;
        this.claseService = claseService;
    }

    @GetMapping
    public String muestraAnimales(Model model) {
        model.addAttribute("listaDeAnimales", animalService.findAll());
        return "index";
    }

    @GetMapping("/Details/{id}")
    public String getDetallesAnimal(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "details";
    }

    @GetMapping("/Create")
    public String getCrearAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("clases", claseService.listarClases());
        return "create";
    }

    @PostMapping("/Create")
    public String postCrearAnimal(@Validated @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            animalService.addAnimal(animal);
            return "redirect:/Animal";
        }
    }

    @GetMapping("/Edit/{id}")
    public String getEditarAnimal(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        model.addAttribute("clases", claseService.listarClases());
        return "edit";
    }

    @PostMapping("/Edit/{id}")
    public String postEditarAnimal(@PathVariable int id, @Validated @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            Animal existingAnimal = animalService.getAnimalById(id);
            if (existingAnimal != null) {
                existingAnimal.setNombre(animal.getNombre());
                existingAnimal.setVidaMedia(animal.getVidaMedia());
                existingAnimal.setExtinto(animal.getExtinto());
                existingAnimal.setClaseId(animal.getClaseId());
                animalService.updateAnimal(existingAnimal);
            }
            return "redirect:/Animal";
        }
    }

    @GetMapping("/Delete/{id}")
    public String getEliminarAnimal(@PathVariable int id, Model model) {
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "delete";
    }

    @PostMapping("/Delete/{id}")
    public String postEliminarAnimal(@PathVariable int id) {
        if (animalService.deleteAnimal(id)) {
            return "redirect:/Animal";
        } else {
            return "delete";
        }
    }
}
