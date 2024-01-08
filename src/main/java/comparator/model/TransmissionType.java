package comparator.model;

public enum TransmissionType {
    MANUAL("Manualna"),
    AUTOMATIC("Automatyczna");

    private final String text;

    TransmissionType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}