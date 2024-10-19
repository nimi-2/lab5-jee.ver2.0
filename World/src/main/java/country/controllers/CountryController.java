package country.controllers;


import country.entities.Country;
import country.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/countriesByContinent/{continent}")
    @ResponseBody
    public String getCountriesByContinent(@PathVariable String continent) {
        List<Country> countries = countryRepository.findByContinent(continent);
        StringBuilder response = new StringBuilder();
        for (Country country : countries) {
            response.append(country).append("<br>");
        }
        return response.toString();
    }

    @RequestMapping("/countriesByPopulation/{min}/{max}")
    @ResponseBody
    public String getCountriesByPopulationRange(@PathVariable int min, @PathVariable int max) {
        List<Country> countries = countryRepository.findByPopulationBetween(min, max);
        StringBuilder response = new StringBuilder();
        for (Country country : countries) {
            response.append(country).append("<br>");
        }
        return response.toString();
    }
}