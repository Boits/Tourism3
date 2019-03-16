package country.domain;

public class CountryWithHotClimate extends Country {
    private String hottestMonth;
    private double averageTemperature;

    CountryWithHotClimate(int telephoneCode, String hottestMonth, double averageTemperature) {
        super.telephoneCode = telephoneCode;
        this.hottestMonth = hottestMonth;
        this.averageTemperature = averageTemperature;
    }

    public String getHottestMonth() {
        return hottestMonth;
    }

    public void setHottestMonth(String hottestMonth) {
        this.hottestMonth = hottestMonth;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    public String toString() {
        return id + " " + hottestMonth + " " + averageTemperature;
    }

    @Override
    public Discriminator getDiscriminator(){
        return discriminator = Discriminator.HOT;
    }
}
