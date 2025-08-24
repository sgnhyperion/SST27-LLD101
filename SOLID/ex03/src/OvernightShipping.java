public class OvernightShipping implements ShippingCostStrategy {

    @Override
    public double cost(double weightKg) {
        return 120 + 10 * weightKg;
    }
    
}
