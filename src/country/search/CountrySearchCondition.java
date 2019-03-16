package country.search;

import common.business.search.BaseSearchCondition;

public class CountrySearchCondition extends BaseSearchCondition<Long> {
    private String name;
    private String language;
    private CounrtryOrderByField orderByField;

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

    public CounrtryOrderByField getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(CounrtryOrderByField orderByField) {
        this.orderByField = orderByField;
    }
}