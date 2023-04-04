package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaRepository fruitaRepository;

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita newfruita) {
        try {
            Fruita savedFruit = fruitaRepository.save(new Fruita(newfruita.getId(), newfruita.getNom(), newfruita.getQuantitatQuilos()));
            return new ResponseEntity<>(savedFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") int id, @RequestBody Fruita fruitaToUpdate) {
        Optional<Fruita> fruitData = fruitaRepository.findById(id);

        if (fruitData.isPresent()) {
            Fruita fruitFromDb = fruitData.get();
            fruitFromDb.setNom(fruitaToUpdate.getNom());
            fruitFromDb.setQuantitatQuilos(fruitaToUpdate.getQuantitatQuilos());
            return new ResponseEntity<>(fruitaRepository.save(fruitFromDb), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") int id) {
        Optional<Fruita> fruitData = fruitaRepository.findById(id);
        if (fruitData.isPresent()) {
            try {
                fruitaRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") int id) {
        Optional<Fruita> fruitData = fruitaRepository.findById(id);

        if (fruitData.isPresent()) {
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        try {
            List<Fruita> fruits = fruitaRepository.findAll();
            if (!fruits.isEmpty()) {
                return new ResponseEntity<>(fruits, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}