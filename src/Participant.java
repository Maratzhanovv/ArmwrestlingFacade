public class Participant {
    private final String name;
    private final double weight;

    public Participant(String name, double weight) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!Double.isFinite(weight) || weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.name = name.trim();
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}