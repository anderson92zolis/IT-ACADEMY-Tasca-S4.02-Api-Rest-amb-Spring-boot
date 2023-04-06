package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.controllers;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.Message;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.FruitaDto;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.services.FruitaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/fruita")
public class FruitaController {

    /*
    controller: Package where the class that acts as a Rest controller is created, that is to say expose the APIs that are defined.
     */

    @Autowired
    private FruitaService fruitaServices;

    //add a new user
    @PostMapping("/add")
    public ResponseEntity<Message> addFruita(@RequestBody FruitaDto fruitaDto) {
        ResponseEntity<Message> validationResult = fruitaServices.validateFruitaDto(fruitaDto);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitaServices.createFruita(fruitaDto);
            return new ResponseEntity<>(new Message("Successfully created fruit"), HttpStatus.CREATED);
        } else {
            return validationResult;
        }
    }



    // update an existing user
    @PutMapping("/update/{id}")
    public ResponseEntity<Message> updateFruita(@PathVariable int id, @RequestBody FruitaDto fruitaDto) {
        Optional<Fruita> fruita = fruitaServices.getFruitaById(id);
        if (fruita.isPresent()) {
            Fruita updatedFruita = fruitaServices.updateFruitaById(id, fruitaDto);
            return new ResponseEntity<>(new Message("Fruit with ID " + id + " updated."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Fruit with ID " + id + " not found."), HttpStatus.NOT_FOUND);
        }
    }

    // delete an existing user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteFruita(@PathVariable int id) {
        ResponseEntity<Message> checkId = fruitaServices.validateFruitaId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            fruitaServices.deleteFruitaById(id);
            return new ResponseEntity<>(new Message("Fruit deleted."), HttpStatus.OK);
        } else {
            return checkId;
        }
    }

    // read an user
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getFruitaById(@PathVariable int id) {
        ResponseEntity<Message> checkId = fruitaServices.validateFruitaId(id);

        if (checkId.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(fruitaServices.getFruitaById(id), HttpStatus.OK);
        } else {
            return checkId;
        }
    }


    // read all users
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {

        List<Fruita> fruits = fruitaServices.fruitesList();
        if (!fruits.isEmpty()) {
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}