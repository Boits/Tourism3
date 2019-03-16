package country.search;

public enum CounrtryOrderByField {
    LANGUAGE("Language in Country"),
    NAME("Country Name");

    CounrtryOrderByField(String requestParamName) {
        this.requestParamName = requestParamName;
    }

    private String requestParamName;

    public String getRequestParamName() {
        return requestParamName;
    }
}
