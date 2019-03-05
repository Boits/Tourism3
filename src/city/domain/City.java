package city.domain;

import common.business.domain.BaseDomain;

public class City extends BaseDomain implements Comparable<City>{
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

    public City(String nameCity){
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
        return id+" " + nameCity + " " + population;
    }

    @Override
    public int compareTo(City other) {
        if (other != null) {
            return Long.compare(this.id, other.id);
        }
        return 1;
    }
}
