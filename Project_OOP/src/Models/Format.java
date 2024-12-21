package Models;

public enum Format {
    PLAINTEXT("Plaintext"),
    BIBTEX("Bibtex");
    
    private final String displayFormat;

	Format(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public String displayFormat() {
        return displayFormat;
    }

    @Override
    public String toString() {
        return displayFormat;
    }
}
