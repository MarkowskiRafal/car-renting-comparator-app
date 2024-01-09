package comparator.model;

public enum TransmissionType {
    MANUAL("Manual"),
    AUTOMATIC("Automatic");

    private final String text;

    TransmissionType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}