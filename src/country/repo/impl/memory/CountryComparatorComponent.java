package country.repo.impl.memory;

import country.domain.Country;
import country.search.CounrtyOrderByField;

import java.util.*;

import static common.business.repo.memory.CommonComparatorHolder.getComparatorForNullableStrings;
import static country.search.CounrtyOrderByField.LANGUAGE;
import static country.search.CounrtyOrderByField.NAME;

public final class CountryComparatorComponent {
    private static final CountryComparatorComponent INSTANCE = new CountryComparatorComponent();
    private static Map<CounrtyOrderByField, Comparator<Country>> comparatorsByField = new HashMap<>();
    /**
     * For complex comparator only
     */
    private static Set<CounrtyOrderByField> fieldComparePriorityOrder = new LinkedHashSet<>(Arrays.asList(LANGUAGE, NAME));

    static {
        comparatorsByField.put(LANGUAGE, getComparatorForLanguageField());
        comparatorsByField.put(NAME, getComparatorForNameField());
    }

    private CountryComparatorComponent() {
    }


    public static CountryComparatorComponent getInstance() {
        return INSTANCE;
    }

    private static Comparator<Country> getComparatorForNameField() {
        return new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return getComparatorForNullableStrings().compare(country1.getName(), country2.getName());
            }
        };
    }

    private static Comparator<Country> getComparatorForLanguageField() {
        return new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                return getComparatorForNullableStrings().compare(country1.getLanguage(), country2.getLanguage());
            }
        };
    }

    public Comparator<Country> getComparatorForField(CounrtyOrderByField field) {
        return comparatorsByField.get(field);
    }

    public Comparator<Country> getComplexComparator(CounrtyOrderByField field) {
        return new Comparator<Country>() {

            @Override
            public int compare(Country c1, Country c2) {
                int result = 0;
                Comparator<Country> countryComparator = comparatorsByField.get(field);

                if (countryComparator != null) {
                    result = countryComparator.compare(c1, c2);
                    //if records have same order priority, i want to order them in their group
                    if (result == 0) {

                        //loop through all possible sorting fields
                        for (CounrtyOrderByField otherField : fieldComparePriorityOrder) {
                            //if i haven't sorted by field which is taken from parameter in function, i do sorting
                            if (!otherField.equals(field)) {

                                result = comparatorsByField.get(otherField).compare(c1, c2);
                                //if sort result detected that records are not equals - we exit from loop,
                                //else continue
                                if (result != 0) {
                                    break;
                                }
                            }
                        }

                    }
                }


                return result;
            }
        };
    }
}
