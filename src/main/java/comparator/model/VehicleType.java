package comparator.model;

public enum VehicleType {
    SEDAN("Sedan"),
    COUPE("Coupe"),
    WAGON("Wagon"),
    DELIVERY_VAN("Delivery Van"),
    SUV("Suv"),
    CABRIOLET("Cabriolet"),
    SPORTCAR("Sport Car");

    private final String text;

    VehicleType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}