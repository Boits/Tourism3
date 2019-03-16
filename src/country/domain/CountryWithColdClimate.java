package country.domain;

public class CountryWithColdClimate extends Country {
    private boolean polarNight;

    CountryWithColdClimate(int telephoneCode, boolean polarNight) {
        super.telephoneCode = telephoneCode;
        this.polarNight = polarNight;
    }

    public boolean isPolarNight() {
        return polarNight;
    }

    public void setPolarNight(boolean polarNight) {
        this.polarNight = polarNight;
    }

    @Override
    public Discriminator getDiscriminator(){
        return discriminator = Discriminator.COLD;
    }
}
