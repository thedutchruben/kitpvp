package nl.thedutchruben.kitpvp.utils;

public class Replacement {
    private String key;
    private String replacement;

    public Replacement(String key, String replacement) {
        this.key = key;
        this.replacement = replacement;
    }

    public String getKey() {
        return key;
    }

    public String getReplacement() {
        return replacement;
    }
}
