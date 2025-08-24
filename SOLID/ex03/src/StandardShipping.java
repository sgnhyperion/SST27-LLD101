public class StandardShipping implements ShippingCostStrategy {

    @Override
    public double cost(double weightKg) {
        return 50 + 5 * weightKg;
    }
    
}
