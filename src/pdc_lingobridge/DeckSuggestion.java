package pdc_lingobridge;

public class DeckSuggestion {
    private String username;
    private String categorySuggestion;

    public DeckSuggestion(String username, String categorySuggestion) {
        this.username = username;
        this.categorySuggestion = categorySuggestion;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategorySuggestion() {
        return categorySuggestion;
    }

    public void setCategorySuggestion(String categorySuggestion) {
        this.categorySuggestion = categorySuggestion;
    }
}
