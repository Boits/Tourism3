package city;

public class City {
    private String nameCity;
    private double population;
    private boolean capital;

    City(String nameCity, double population, boolean capital) {
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
        return nameCity;
    }
}
