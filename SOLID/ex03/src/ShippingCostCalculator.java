public class ShippingCostCalculator {


    double cost(Shipment s){
        return s.strategy.cost(s.weightKg);
    }
}
