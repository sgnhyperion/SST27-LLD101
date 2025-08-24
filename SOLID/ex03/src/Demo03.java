public class Demo03 {
    public static void main(String[] args) {
        Shipment express = new Shipment(new ExpressShipping(), 2);
        Shipment standard = new Shipment(new StandardShipping(), 10);
        Shipment overnight = new Shipment(new OvernightShipping(), 2.4);

        ShippingCostCalculator calc = new ShippingCostCalculator();
        System.out.println("Express: " + calc.cost(express));
        System.out.println("Standard: " + calc.cost(standard));
        System.out.println("Overnight: " + calc.cost(overnight));
    }
}
