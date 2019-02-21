package country;

public class Country {
    private String location;
    private String language;

    Country(String location, String language) {
        this.location = location;
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return location;
    }
}