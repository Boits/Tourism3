package country.search;

import common.business.search.BaseSearchCondition;

public class CountrySearchCondition extends BaseSearchCondition<Long> {
    private String name;
    private String language;
    private CounrtyOrderByField orderByField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public CounrtyOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CounrtyOrderByField orderByField) {
        this.orderByField = orderByField;
    }
}