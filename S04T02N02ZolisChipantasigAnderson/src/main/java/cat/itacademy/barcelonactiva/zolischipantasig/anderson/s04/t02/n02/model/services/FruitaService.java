package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.FruitaDto;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.Dto.Message;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.repository.FruitaRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    private FruitaRepository fruitaRepository;

    public List<Fruita> fruitsList() {
        return fruitaRepository.findAll();
    }

    public Optional<Fruita> getFruitById(int id) {
        return fruitaRepository.findById(id);
    }

    public void deleteFruitById(int id) {
        fruitaRepository.deleteById(id);
    }

    /**
     * Mètode per validar l'existència de la fruita per id en els mètodes del RestController.
     */
    public ResponseEntity<Message> validateFruitId(int id) {
        if (fruitaRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("Fruit id validated successfully."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("ERROR. The id entered does not exist."), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Mètode per validar les dades introduïdes (name i quantityKg) de la fruita en els mètodes del RestController.
     */
    public ResponseEntity<Message> validateFruitDto(FruitaDto fruitDto) {

        if (StringUtils.isBlank(fruitDto.getNom())) {
            return new ResponseEntity<>(new Message("ERROR. The name is required."), HttpStatus.BAD_REQUEST);
        }
        if (fruitDto.getQuantityKg() <= 0) {
            return new ResponseEntity<>(new Message("ERROR. Quantity must be greater than 0."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Fruit validated successfully."), HttpStatus.OK);
    }

    /**
     * Mètode per encapsular la lògica de crear una fruita en el mètode addFruit del controlador.
     */
    public Fruita createFruit(FruitaDto fruitaDto) {
        Fruita newFruit = new Fruita(fruitaDto.getNom(), fruitaDto.getQuantityKg());
        return fruitaRepository.save(newFruit);
    }

    /**
     * Mètode per encapsular la lògica d'actualitzar una fruita en el mètode updateFruit del controlador.
     */
    public Fruita updateFruitById(int id, FruitaDto fruitDto) {
        Fruita fruitFromDb = fruitaRepository.findById(id).get();
        ResponseEntity<Message> validationResult = validateFruitDto(fruitDto);

        if (validationResult.getStatusCode() == HttpStatus.OK) {
            fruitFromDb.setNom(fruitDto.getNom());
            fruitFromDb.setQuantitatQuilos(fruitDto.getQuantityKg());
            fruitaRepository.save(fruitFromDb);
        }
        return fruitFromDb;
    }


}