package country.domain;

import common.business.domain.BaseDomain;

public class Country extends BaseDomain {
    private String name;
    private String language;

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

    @Override
    public String toString() {
        return id + " " + name + " " + language;
    }
}