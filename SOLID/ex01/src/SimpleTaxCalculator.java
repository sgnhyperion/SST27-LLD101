public class SimpleTaxCalculator implements ITaxCalculator {
    private final double taxRate;

    public SimpleTaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double calculate(double subtotal) {
        return subtotal + subtotal * taxRate;
    }
}
