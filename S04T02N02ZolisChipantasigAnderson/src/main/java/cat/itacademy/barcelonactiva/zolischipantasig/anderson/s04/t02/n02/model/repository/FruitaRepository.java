package cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.itacademy.barcelonactiva.zolischipantasig.anderson.s04.t02.n02.model.domain.Fruita;
import org.springframework.stereotype.Repository;


/**
 * To manage persistence with the database.
 */

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {

    /*
     * repository: Package in which the class is created whose particularity is that it extends JpaRepository which allows us to manage the fundamental CRUD operations.
     */
}
