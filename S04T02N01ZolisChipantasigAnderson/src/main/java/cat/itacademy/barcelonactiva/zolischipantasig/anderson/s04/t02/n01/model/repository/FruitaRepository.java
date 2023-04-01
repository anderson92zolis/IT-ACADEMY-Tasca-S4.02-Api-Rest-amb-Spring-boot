package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n01.model.domain.Fruita;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
}
