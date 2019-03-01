package city.domain;

import common.business.domain.BaseDomain;
import country.domain.Country;

public class City extends BaseDomain {
    private String nameCity;
    private String country;
    private double population;
    private boolean capital;
    private Country[] countries;

    public City() {
    }

    public City(String nameCity, String country){
        this.nameCity = nameCity;
        this.country = country;
    }

    public City(String nameCity, double population, boolean capital) {
        this.nameCity = nameCity;
        this.population = population;
        this.capital = capital;
    }

    public String getNameCity() {
        return nameCity;
    }

    public double getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return capital;
    }

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return id + " " + nameCity + " " + country;
    }

}
