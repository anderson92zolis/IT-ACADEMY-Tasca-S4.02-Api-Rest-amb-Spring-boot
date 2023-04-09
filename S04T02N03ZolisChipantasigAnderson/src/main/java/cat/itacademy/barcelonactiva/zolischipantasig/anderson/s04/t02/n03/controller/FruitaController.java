package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.controller;


import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FruitaController {

    @Autowired
    private FruitaRepository fruitaRepository;

    @PostMapping("/add")
    public String saveBook(@RequestBody Fruita fruita) {
        fruitaRepository.save(fruita);
        return "Added fruit! "+fruita.getNom();
    }

    @GetMapping("/getAll")
    public List<Fruita> getBooks() {
        return fruitaRepository.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Optional<Fruita> getBook(@PathVariable int id) {
        return fruitaRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        fruitaRepository.deleteById(id);
        return "fruita deleted with id : " + id;
    }
}