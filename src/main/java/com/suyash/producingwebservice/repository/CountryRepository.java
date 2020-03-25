package com.suyash.producingwebservice.repository;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countryMap = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country country1 = new Country();
        country1.setName("India");
        country1.setCapital("New Delhi");
        country1.setCurrency(Currency.INR);
        country1.setPopulation(132000000);

        countryMap.put(country1.getName(), country1);

        Country country2 = new Country();

        country2.setName("Poland");
        country2.setCapital("Warsaw");
        country2.setCurrency(Currency.PLN);
        country2.setPopulation(38186860);

        countryMap.put(country2.getName(), country2);

        Country country3 = new Country();

        country3.setName("United Kingdom");
        country3.setCapital("London");
        country3.setCurrency(Currency.EUR);
        country3.setPopulation(63705000);

        countryMap.put(country3.getName(), country3);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countryMap.get(name);
    }
}
