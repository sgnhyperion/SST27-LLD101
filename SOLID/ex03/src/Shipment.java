public class Shipment {
    ShippingCostStrategy strategy;
    double weightKg;

    public Shipment(ShippingCostStrategy strategy, double weightKg) {
        this.strategy = strategy;
        this.weightKg = weightKg;
    }
}