package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.controller;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.Service.FruitaService;
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
    private FruitaService fruitaService;

    /*@PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@RequestBody Fruita fruita) {
        System.out.println("Creating new fruit with name " + fruita.getNom() + " and  weight Kg  " + fruita.getQuantitatQuilos() + ".");
        Fruita savedFruita = fruitaService.createFruita(fruita);
        return new ResponseEntity<>(savedFruita, HttpStatus.CREATED);
    }*/

    @PostMapping("/add")
    public ResponseEntity<?> createFruita(@RequestBody Fruita fruita) {
        String message = Message.createFruit(fruita.getNom(), fruita.getQuantitatQuilos());
        System.out.println(message);
        Fruita savedFruita = fruitaService.createFruita(fruita);
        if (savedFruita == null) {
            message = Message.createFruitError(fruita.getNom());
            return new ResponseEntity<>(new MessageResponse("error"+ message), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(new MessageResponse("Success created" + savedFruita), HttpStatus.CREATED);
        }
    }

    /*
    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable int id, @RequestBody Fruita fruita) {
        Optional<Fruita> fruitaOptional = fruitaService.updateFruita(id, fruita);
        if (fruitaOptional.isPresent()) {
            return new ResponseEntity<>(fruitaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    */

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFruita(@PathVariable int id, @RequestBody Fruita fruita) {
        String message = Message.updateFruit(id, fruita.getNom(), fruita.getQuantitatQuilos());
        System.out.println(message);
        Optional<Fruita> fruitaOptional = fruitaService.updateFruita(id, fruita);
        if (fruitaOptional.isPresent()) {
            return new ResponseEntity<>(new MessageResponse("success"+message ), HttpStatus.OK);
        } else {
            message = Message.updateFruitError(id);
            return new ResponseEntity<>(new MessageResponse("error"+ message), HttpStatus.NOT_FOUND);
        }
    }

    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable int id) {
        System.out.println("Deleting fruit with ID " + id + " from the database.");
        fruitaService.deleteFruita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruita(@PathVariable int id) {

        Optional<Fruita> fruitaOptional = fruitaService.getFruitaById(id);

        if (fruitaOptional.isPresent()) {
            String message = Message.deleteFruit(id);
            System.out.println(message);
            fruitaService.deleteFruita(id);
            return new ResponseEntity<>(new MessageResponse("success "+ message), HttpStatus.OK);
        } else {
            String message = Message.retrieveFruitByIdError(id);
            System.out.println(message);
            return new ResponseEntity<>(new MessageResponse("Error" +message ),HttpStatus.NOT_FOUND);
        }
    }

    /*
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable int id) {
        Optional<Fruita> fruitaOptional = fruitaService.getFruitaById(id);
        if (fruitaOptional.isPresent()) {
            return new ResponseEntity<>(fruitaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    */

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitaById(@PathVariable int id) {
        String message = Message.retrieveFruitById(id);
        System.out.println(message);
        Optional<Fruita> fruitaOptional = fruitaService.getFruitaById(id);

        if (fruitaOptional.isPresent()) {
            return new ResponseEntity<>(new MessageResponse("success"+ message), HttpStatus.OK);
        } else {
            message = Message.retrieveFruitByIdError(id);
            return new ResponseEntity<>(new MessageResponse("error"+ message), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAll")
    public List<Fruita> getAllFruit() {
        return fruitaService.getAllFruita();
    }
}