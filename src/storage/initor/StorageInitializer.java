package storage.initor;

import country.domain.Country;
import country.service.CountryService;
import storage.initor.datasourcereader.dom.CountriesWithCitiesXmlDomParser;
import storage.initor.datasourcereader.sax.CountriesWithCitiesXmlSaxParser;
import storage.initor.datasourcereader.XmlParser;
import storage.initor.datasourcereader.stax.CountriesWithCitiesXmlStaxParser;

import java.util.List;

public class StorageInitializer {
    private CountryService countryService;

    public StorageInitializer(CountryService countryService) {
        this.countryService = countryService;
    }

    public enum DataSourceType {
        TXT_FILE, XML_FILE
    }

    public void initStorageWithCountriesAndCities(String filePath, DataSourceType dataSourceType) throws Exception {

        List<Country> countryList = getCountriesFromStorage(filePath, dataSourceType);

        if (!countryList.isEmpty()) {
            for (Country country : countryList) {
                countryService.add(country);
            }
        }
    }

    private List<Country> getCountriesFromStorage(String filePath, DataSourceType dataSourceType) throws Exception {

        XmlParser<List<Country>> dataSourceReader = null;

        switch (dataSourceType) {

            case XML_FILE: {
//                dataSourceReader = new CountriesWithCitiesXmlDomParser();
//                dataSourceReader = new CountriesWithCitiesXmlSaxParser();
                dataSourceReader = new CountriesWithCitiesXmlStaxParser();

                break;
            }
        }

        return dataSourceReader.parseFile(filePath);
    }
}
