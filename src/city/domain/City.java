package city.domain;

import common.business.domain.BaseDomain;

import java.util.Objects;

public class City extends BaseDomain<Long> {
    private String nameCity;
    private double population;
    private boolean capital;

    Climate climate;

    public enum Climate {
        TROPIC,
        SUBTROPIC,
        CONTINENTAL,
        ARCTIC,
        ANTARCTIC
    }

    public City() {
    }

    public City(String nameCity) {
        this.nameCity = nameCity;
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

    @Override
    public String toString() {
        return id + " " + nameCity + " " + population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.population, population) == 0 &&
                capital == city.capital &&
                Objects.equals(nameCity, city.nameCity) &&
                climate == city.climate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCity, population, capital, climate);
    }
}
