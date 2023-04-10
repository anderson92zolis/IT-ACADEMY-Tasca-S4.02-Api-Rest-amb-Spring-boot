package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.Service;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {
    @Autowired
    private FruitaRepository fruitaRepository;

    public Fruita createFruita(Fruita fruita) {
        return fruitaRepository.save(fruita);
    }

    public Optional<Fruita> updateFruita(int id, Fruita fruita) {
        Optional<Fruita> fruitaOptional = fruitaRepository.findById(id);
        if (fruitaOptional.isPresent()) {
            fruita.setId(id);
            return Optional.of(fruitaRepository.save(fruita));
        } else {
            return Optional.empty();
        }
    }

    public void deleteFruita(int id) {
        fruitaRepository.deleteById(id);
    }

    public Optional<Fruita> getFruitaById(int id) {
        return fruitaRepository.findById(id);
    }

    public List<Fruita> getAllFruita() {
        return fruitaRepository.findAll();
    }

}
