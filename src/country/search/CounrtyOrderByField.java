package country.search;

public enum CounrtyOrderByField {
    LANGUAGE("Language in Country"),
    NAME("Countryname");

    CounrtyOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
