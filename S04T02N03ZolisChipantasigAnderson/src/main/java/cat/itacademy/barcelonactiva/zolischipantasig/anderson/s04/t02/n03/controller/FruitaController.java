package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.controller;


import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaRepository fruitaRepository;

    /*
    @PostMapping("/add")
    public String createFruita(@RequestBody Fruita fruita) {
        fruitaRepository.save(fruita);
        return "Added fruit! "+fruita.toString();
    }*/

    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
        Fruita savedFruita = fruitaRepository.save(fruita);
        return new ResponseEntity<>(savedFruita, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable int id, @RequestBody Fruita fruita) {
        Optional<Fruita> fruitaOptional = fruitaRepository.findById(id);
        if (fruitaOptional.isPresent()) {
            fruita.setId(id);
            Fruita savedFruita = fruitaRepository.save(fruita);
            return new ResponseEntity<>(savedFruita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }

    /*
    @GetMapping("/getOne/{id}")
    public Optional<Fruita> getBook(@PathVariable int id) {
        return fruitaRepository.findById(id);
    }*/

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable int id) {
        Optional<Fruita> fruitaOptional = fruitaRepository.findById(id);
        if (fruitaOptional.isPresent()) {
            return new ResponseEntity<>(fruitaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*

    @DeleteMapping("/delete/{id}")
    public String deleteFruita(@PathVariable int id) {
        fruitaRepository.deleteById(id);
        return "fruita deleted with id : " + id;
    }  */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable int id) {
        fruitaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}