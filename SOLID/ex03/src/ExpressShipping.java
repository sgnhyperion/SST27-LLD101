public class ExpressShipping implements ShippingCostStrategy {

    @Override
    public double cost(double weightKg) {
        return 80 + 8 * weightKg;
    }
    
}
