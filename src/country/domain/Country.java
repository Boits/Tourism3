package country.domain;

import city.domain.City;
import common.business.domain.BaseDomain;

import java.util.List;

public class Country extends BaseDomain{
    private String name;
    private String language;
    private List<City> cities;

    public Country(){

    }
    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return id+" "+name + " " + language;
    }

    public String getStr() {
        return "id=" + id +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' ;

    }
}