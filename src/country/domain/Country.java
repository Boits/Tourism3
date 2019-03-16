package country.domain;

import city.domain.City;
import common.business.domain.BaseDomain;
import order.domain.Order;

import java.util.List;

public class Country extends BaseDomain<Long> {
    private String name;
    private String language;
    private List<City> cities;
    protected int telephoneCode;
    protected Discriminator discriminator;

    public Country() {
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

    public int getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(int telephoneCode) {
        this.telephoneCode = telephoneCode;
    }

    public Discriminator getDiscriminator() {
        return discriminator;
    }

//    public void setDiscriminator(Discriminator discriminator) {
//        this.discriminator = discriminator;
//    }


    @Override
    public String toString() {
        return new StringBuilder().append("Id: ").append(id).append("; Country: ").append(name).append("; Language: ").append(language).toString();
    }
//    @Override
//    public String toString() {
//        return id + " " + name + " " + language;
//    }

}