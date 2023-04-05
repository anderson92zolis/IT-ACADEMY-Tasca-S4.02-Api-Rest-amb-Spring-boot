package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.Message;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.FruitaDto;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruita")
public class FruitaController {

    @Autowired
    private FruitaService fruitaServices;

    //add a new user
    @PostMapping("/add")
    public ResponseEntity<Message> addFruita(@RequestBody FruitaDto fruitaDto) {
        ResponseEntity<Message> validationResult = fruitaServices.validateFruitDto(fruitaDto);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitaServices.createFruit(fruitaDto);
            return new ResponseEntity<>(new Message("Fruit created correctly."), HttpStatus.CREATED);
        } else {
            return validationResult;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruita(@PathVariable int id, @RequestBody FruitaDto fruitDto) {
        ResponseEntity<Message> checkId = fruitaServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitaServices.updateFruitById(id, fruitDto);
            return new ResponseEntity<>(new Message("Fruit updated."), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruita(@PathVariable int id) {
        ResponseEntity<Message> checkId = fruitaServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitaServices.deleteFruitById(id);
            return new ResponseEntity<>(new Message("Fruit removed."), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    // read an user
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitaById(@PathVariable int id) {
        ResponseEntity<Message> checkId = fruitaServices.validateFruitId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(fruitaServices.getFruitById(id), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {

        List<Fruita> fruits = fruitaServices.fruitsList();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}