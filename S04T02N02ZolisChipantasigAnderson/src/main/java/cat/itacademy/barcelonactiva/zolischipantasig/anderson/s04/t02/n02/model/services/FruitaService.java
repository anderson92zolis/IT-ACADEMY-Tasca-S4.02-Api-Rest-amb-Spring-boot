package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.FruitaDto;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.Message;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.repository.FruitaRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    /*
    service: Package where the class is created whose purpose is to implement the methods that are defined for the application.
     */

    @Autowired
    private FruitaRepository fruitaRepository;

    public List<Fruita> fruitesList() {
        return fruitaRepository.findAll();
    }

    public Optional<Fruita> getFruitaById(int id) {
        return fruitaRepository.findById(id);
    }

    public void deleteFruitaById(int id) {
        fruitaRepository.deleteById(id);
    }

    /*
     * This method validates the existence of a fruit by ID in the REST controller's methods.
     */

    public ResponseEntity<Message> validateFruitaId(int id) {
        if (fruitaRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("Fruit ID validated successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("ERROR. The ID entered does not exist."), HttpStatus.NOT_FOUND);
        }
    }

    /*
     * Method to validate the entered data (name and quantityKg) of the fruit in the RestController methods.
     */

    public ResponseEntity<Message> validateFruitaDto(FruitaDto fruitaDto) {

        if (StringUtils.isBlank(fruitaDto.getNom())) {
            return new ResponseEntity<>(new Message("ERROR. The name is required."), HttpStatus.BAD_REQUEST);
        }
        if (fruitaDto.getQuantitatQuilos() <= 0) {
            return new ResponseEntity<>(new Message("ERROR. Quantity must be greater than 0."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Fruit validated successfully."), HttpStatus.OK);
    }

    /*
     * Method to encapsulate the logic of creating a fruit in the controller's addFruita method.
     */

    public Fruita createFruita(FruitaDto fruitaDto) {
        Fruita newFruita = new Fruita(fruitaDto.getNom(), fruitaDto.getQuantitatQuilos());
        return fruitaRepository.save(newFruita);
    }


    /*
     * Method to encapsulate the logic of updating a fruit in the controller's updateFruita method.
     */

    public Fruita updateFruitaById(int id, FruitaDto fruitaDto) {

        Fruita fruitaFromDb = fruitaRepository.findById(id).get();

        if (fruitaFromDb != null) {

            ResponseEntity<Message> validationResult = validateFruitaDto(fruitaDto);

            if (validationResult.getStatusCode() == HttpStatus.OK) {
                fruitaFromDb.setNom(fruitaDto.getNom());
                fruitaFromDb.setQuantitatQuilos(fruitaDto.getQuantitatQuilos());
                fruitaRepository.save(fruitaFromDb);
            }
        }
        return fruitaFromDb;
    }
}