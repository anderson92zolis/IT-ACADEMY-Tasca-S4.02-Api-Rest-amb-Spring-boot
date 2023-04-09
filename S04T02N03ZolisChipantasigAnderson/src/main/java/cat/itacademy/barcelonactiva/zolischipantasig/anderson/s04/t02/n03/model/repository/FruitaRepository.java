package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n03.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface FruitaRepository extends MongoRepository<Fruita, Integer> {
}
