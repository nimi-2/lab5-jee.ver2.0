package country.repositories;

import country.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, String> {

    List<Country> findByContinent(String continent);

    List<Country> findByPopulationBetween(int minPopulation, int maxPopulation);

    List<Country> findByContinentAndSurfaceAreaBetween(String continent, double minSurfaceArea, double maxSurfaceArea);
}
